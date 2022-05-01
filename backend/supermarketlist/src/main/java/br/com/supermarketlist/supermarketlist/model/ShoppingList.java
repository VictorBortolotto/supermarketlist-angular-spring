package br.com.supermarketlist.supermarketlist.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private boolean status;

    @ManyToMany
    @JoinTable(
        name = "product_shopping_list",
        joinColumns = @JoinColumn(name = "id_shopping_list"),
        inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List<ShoppingList> shoppingListProduct;

    public ShoppingList() {
    }

    public ShoppingList(String name, boolean status) {
        this.name = name;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
