package br.com.supermarketlist.supermarketlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supermarketlist.supermarketlist.model.ShoppingList;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    
}
