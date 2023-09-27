package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping(value="/save-product")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product product){
		boolean isSaved=service.saveProduct(product);
		if(isSaved) {
			return new ResponseEntity<Boolean>(isSaved, HttpStatus.CREATED);
		}else {
			//throw custom exception(ResourceAlreadyExistsException(String msg) )
			return new ResponseEntity<Boolean>(isSaved, HttpStatus.ALREADY_REPORTED);
 
		}
	}
}
