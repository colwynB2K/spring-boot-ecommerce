package com.luv2code.ecommerce.config;

import com.luv2code.ecommerce.domain.Product;
import com.luv2code.ecommerce.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager entityManager) {		// Constructor Injection
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        // Disable HTTP methods for Product: POST, PUT and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

        // Disable HTTP methods for ProductCategory: POST, PUT and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

        // Expose entity ids
        config.exposeIdsFor(getAllEntityClasses().toArray(new Class[0]));
    }

    private Set<Class> getAllEntityClasses() {
        Set<Class> entityClasses = new HashSet<>();

        // Get a list of all entity classes from the EntityManager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // For each entity class, add it's java type (FQDN?) to the list
        for (EntityType currentEntity : entities) {
            entityClasses.add(currentEntity.getJavaType());
        }

        return entityClasses;
    }
}

