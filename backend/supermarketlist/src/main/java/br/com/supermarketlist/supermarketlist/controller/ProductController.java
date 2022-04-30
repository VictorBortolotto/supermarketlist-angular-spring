package br.com.supermarketlist.supermarketlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.supermarketlist.supermarketlist.model.Product;
import br.com.supermarketlist.supermarketlist.repository.ProductRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/super")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/products")
    @ResponseBody
    public Iterable<Product> getProducts(){
        return productRepository.findAllProducts();
    }

}
