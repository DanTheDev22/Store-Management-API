package com.example.Store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name" )
    private String name;

    @Column(name = "brand" )
    private String brand;

    @Column(name = "category"  )
    private String category;

    @Column(name = "price"  )
    private Double price;

    @Column(name = "quantity"  )
    private Integer quantity;

    @Column(name = "created_at"  )
    private LocalDate created_at;

    public Product(Long id, String name, String brand, String category, Double price, Integer quantity,
                   LocalDate created_at) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.created_at = created_at;
    }

    public Product () {}


}
