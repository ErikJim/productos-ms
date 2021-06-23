package com.floresJimenez.productosms.repositories;

import com.floresJimenez.productosms.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends MongoRepository<Product, String> {
}
