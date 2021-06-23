package com.floresJimenez.productosms.services;

import com.floresJimenez.productosms.entities.Product;

import java.util.List;

public interface ProductoService {

    List<Product> findAll();

    Product findById(String id);

    Long count();

    void deleteById(String id);

    Product save(Product product);

    Product updateProduct(Product product);

    void addImage(String productId, String imageId);
}
