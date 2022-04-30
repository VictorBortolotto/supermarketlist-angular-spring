package br.com.supermarketlist.supermarketlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.supermarketlist.supermarketlist.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByemail(@Param("email") String email);

    Boolean existsByEmail(@Param("email") String email);

}
