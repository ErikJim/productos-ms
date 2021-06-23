package com.floresJimenez.productosms.services;

import com.floresJimenez.productosms.entities.Image;
import com.floresJimenez.productosms.entities.dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImagesService {
    Image saveImage (String id, MultipartFile file, Long number) throws Exception;

    List<ImageDto> getImagesByProduct(String id);

    ImageDto getImageById(String id);
}
