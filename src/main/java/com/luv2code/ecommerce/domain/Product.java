package com.luv2code.ecommerce.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "date_created")
    @CreationTimestamp                      // We don't need to explicitly call this method, Hibernate takes care of this
    private LocalDateTime created;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "last_updated")
    @UpdateTimestamp                        // We don't need to explicitly call this method, Hibernate takes care of this
    private LocalDateTime lastUpdated;

    @Column(name = "name")
    private String name;

    @Column(name = "sku")
    private String sku;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory productCategory;
}
