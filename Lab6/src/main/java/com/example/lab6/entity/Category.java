package com.example.lab6.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category implements Serializable {
    @Id
    @Column(name = "Id", length = 10)
    private String id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {}
    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
