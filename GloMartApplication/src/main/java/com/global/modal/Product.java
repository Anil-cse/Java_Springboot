package com.global.modal;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private float price;
    
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    
    
}


