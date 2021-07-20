package com.floresJimenez.productosms.controllers;

import com.floresJimenez.productosms.entities.Image;
import com.floresJimenez.productosms.entities.Product;
import com.floresJimenez.productosms.entities.dto.ImageDto;
import com.floresJimenez.productosms.services.ImagesServiceImpl;
import com.floresJimenez.productosms.services.ProductoService;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ImagesServiceImpl imagesService;

    @GetMapping("/search")
    public List<Product> getAllProduct() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return productoService.findById(id);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productoService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productoService.deleteById(id);
    }

    @PostMapping("/image/{id}")
    public Image saveImage(@PathVariable String id,
                          @RequestParam("number") Long number,
                          @RequestParam("file") MultipartFile file) throws Exception {
        return imagesService.saveImage(id, file, number);
    }

    @GetMapping("/image/{id}")
    public  List<ImageDto> getImage(@PathVariable String id) {
        return imagesService.getImagesByProduct(id);
    }

    @GetMapping("/imageByImageId/{id}")
    public Model getPhoto(@PathVariable String id, Model model) {
        ImageDto photo = imagesService.getImageById(id);
        model.addAttribute("title", photo.getNumberImage());
        model.addAttribute("image", photo.getImage());
        return model;
    }

}
