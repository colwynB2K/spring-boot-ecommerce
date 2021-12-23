package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@RequestParam("keyword") String keyword, Pageable pageable);				// if method name has 'Containing' in it, this will translate into a query based on keyword 'LIKE' => WHERE name LIKE CONCAT('%', :keyword , '%')
}
