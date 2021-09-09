package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(path = "product-categories", collectionResourceRel = "categories")
// Expose Repository as REST API endpoint:
// specify endpoint path (otherwise it will like just stick an 's' to the end like '/productCategories'.
// collectionResourceRel specifies the name of the JSON entry, So if you browse to 'http://localhost:8080/api/product-categories', this defines the name of the root collection property
// We don't need this for the ProductRepository as we will take the defaults there
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
