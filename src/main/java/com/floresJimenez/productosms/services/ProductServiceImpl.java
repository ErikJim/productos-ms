package com.floresJimenez.productosms.services;

import com.floresJimenez.productosms.entities.Product;
import com.floresJimenez.productosms.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductoService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Long count() {
        return productRepository.count();
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product save(Product product) {
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if (Objects.nonNull(product.getId()) && productRepository.existsById(product.getId())) {
            product.setUpdateAt(new Date());
        }
        return productRepository.save(product);
    }

    @Override
    public void addImage(String productId, String imageId) {
        Product product = productRepository.findById(productId).get();
        if (Objects.isNull(product.getImages())) {
            List<String> images = new ArrayList<>();
            images.add(imageId);
            product.setImages(images);
        } else {
            product.getImages().add(imageId);
        }

        this.updateProduct(product);
    }
}
