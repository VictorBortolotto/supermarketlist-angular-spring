package br.com.supermarketlist.supermarketlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.supermarketlist.supermarketlist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
        value = "select * from product",
        nativeQuery = true
    )
    List<Product> findAllProducts();

    List<Product> findProductById(@Param("id") long id);

    List<Product> findProductByName(@Param("name") String name);
}
