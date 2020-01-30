package com.example.project.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.project.domain.Product;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.ProductRepository;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new DataNotFoundException("Evento Not found"));
    }

    public String updateImage (String image, Integer id) {
        Product product = findById(id);
        product.setImagem(image);
        productRepository.save(product);
        return image;
    }

    public Product createProduct(Product model) {
        return productRepository.save(model);

    }

    
}