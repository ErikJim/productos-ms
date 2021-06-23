package com.floresJimenez.productosms.services;

import com.floresJimenez.productosms.entities.Image;
import com.floresJimenez.productosms.entities.Product;
import com.floresJimenez.productosms.entities.dto.ImageDto;
import com.floresJimenez.productosms.repositories.ImagesRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service("ImagesService")
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    public Image saveImage(String productId, MultipartFile file, Long number) throws Exception {
        Image image = new Image();
        image.setNumberImage(number);
        image.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        image = imagesRepository.insert(image);
        productoService.addImage(productId, image.getId());
        return image;
    }

    @Override
    public List<ImageDto> getImagesByProduct(String productId) {
        Product producto = productoService.findById(productId);
        List<ImageDto> images = new ArrayList<>();
        if (Objects.nonNull(producto.getImages()) && !producto.getImages().isEmpty()) {
            for (String imagenId : producto.getImages()) {
                ImageDto imgDto = new ImageDto();
                Image img = imagesRepository.findById(imagenId).get();
                imgDto.setId(img.getId());
                imgDto.setImage(Base64.getEncoder().encodeToString(img.getFile().getData()));
                imgDto.setNumberImage(img.getNumberImage());
                images.add(imgDto);
            }
        }
        return images;
    }

    @Override
    public ImageDto getImageById(String id) {
        ImageDto imgDto = new ImageDto();
        Image img = imagesRepository.findById(id).get();
        imgDto.setId(img.getId());
        imgDto.setImage(Base64.getEncoder().encodeToString(img.getFile().getData()));
        imgDto.setNumberImage(img.getNumberImage());
        return imgDto;
    }


}
