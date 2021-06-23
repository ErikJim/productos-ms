package com.floresJimenez.productosms.repositories;

import com.floresJimenez.productosms.entities.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("imagesRepository")
public interface ImagesRepository extends MongoRepository<Image, String> {

    @Query(" productId : '?0'")
    List<Image> findByProductId(String id);
}
