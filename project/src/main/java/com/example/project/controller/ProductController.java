package com.example.project.controller;


import java.io.IOException;
import java.util.List;

import com.example.project.domain.Product;
import com.example.project.service.FileService;
import com.example.project.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private FileService fileservice;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Product>> list() {
		return ResponseEntity.ok(productService.list());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(productService.findById(id));
	}

	@PostMapping(value = "/upload/{id}")
	public ResponseEntity<String> upload(MultipartFile file, @PathVariable Integer id) {
		String image = fileservice.upload(file);
		return new ResponseEntity<>(productService.updateImage(image, id), HttpStatus.OK);
	}

	@PutMapping(value = "/fileexcel")
	public ResponseEntity<String> tabletoDb() {
		try {
			fileservice.readExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("Foi");
	}
}