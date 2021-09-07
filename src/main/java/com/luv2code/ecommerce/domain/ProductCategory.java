package com.luv2code.ecommerce.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_category")
// @Data -- known bug -> If you use Data you will get an infinite loop when fetching the products from a category due to the bidirectional nature of the relationship
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    private Set<Product> products;
}
