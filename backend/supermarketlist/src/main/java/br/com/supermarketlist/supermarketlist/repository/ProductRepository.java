package br.com.supermarketlist.supermarketlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.supermarketlist.supermarketlist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query(
        value = "select p.* from user u, itens_list il, product p where u.id = il.id_user and p.id = il.id_product",
        nativeQuery = true
    )
    Iterable<Product> findAllProducts();

}
