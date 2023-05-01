package com.global.modal;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    private Long id;

    private int quantity;
    
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    
}
