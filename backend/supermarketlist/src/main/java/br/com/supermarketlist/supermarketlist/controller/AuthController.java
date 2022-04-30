package br.com.supermarketlist.supermarketlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supermarketlist.supermarketlist.model.User;
import br.com.supermarketlist.supermarketlist.payload.request.LoginResquest;
import br.com.supermarketlist.supermarketlist.payload.request.SignUpRequest;
import br.com.supermarketlist.supermarketlist.payload.response.JwtResponse;
import br.com.supermarketlist.supermarketlist.payload.response.MessageResponse;
import br.com.supermarketlist.supermarketlist.repository.UserRepository;
import br.com.supermarketlist.supermarketlist.security.jwt.JwtUtils;
import br.com.supermarketlist.supermarketlist.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginResquest loginRequest){
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetailsImpl.getId(), userDetailsImpl.getEmail(), userDetailsImpl.getPassword(), 200));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> create(@RequestBody SignUpRequest signUpRequest){

        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Email already exists!", 400));
        }

        User newUser = new User(signUpRequest.getNickname(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()));

        userRepository.save(newUser);

        return ResponseEntity.ok(new MessageResponse("Account created with success!", 200));

    }

}
