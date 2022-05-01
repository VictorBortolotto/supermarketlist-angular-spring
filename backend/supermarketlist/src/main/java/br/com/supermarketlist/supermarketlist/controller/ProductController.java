package br.com.supermarketlist.supermarketlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.supermarketlist.supermarketlist.model.Product;
import br.com.supermarketlist.supermarketlist.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok().body(productRepository.findAll());
    }

}
