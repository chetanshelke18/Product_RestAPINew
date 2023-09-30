package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/save-product")
	public ResponseEntity<Boolean> saveProduct(@RequestBody Product product){
		boolean isSaved=service.saveProduct(product);
		if(isSaved) {
			return new ResponseEntity<Boolean>(isSaved, HttpStatus.CREATED);
		}else {
			//throw custom exception(ResourceAlreadyExistsException(String msg) )
			return new ResponseEntity<Boolean>(isSaved, HttpStatus.ALREADY_REPORTED);

		}
	}

	@GetMapping("/get-product-by-id/{productId}")
	public ResponseEntity<Product>getProductById(@PathVariable String productId){
		Product product =service.getProductById(productId);
		if(product!=null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}else {
			return new ResponseEntity<Product>(product,HttpStatus.NO_CONTENT);

		}
	}

	@DeleteMapping("/delete-product")
	public ResponseEntity<Boolean>deleteProduct(@RequestParam String productId){
		boolean isDeleted = service.deleteProductById(productId);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(isDeleted,HttpStatus.NO_CONTENT);

		}
	}

	@PutMapping("update-product")
	public ResponseEntity<Boolean>updateProduct(@RequestBody Product product){
		boolean isUpdated = service.updateProduct(product);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(isUpdated,HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping("/get=allproducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = service.getAllProducts();
		if(products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

		}
	}
	
	@GetMapping("/get-max-priceProduct")
	public ResponseEntity<List<Product>> getMaxPriceProduct(){
		List<Product> list = service.getMaxPriceProduct();
		if(!list.isEmpty()) 
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		else 
			return new ResponseEntity<List<Product>>(list, HttpStatus.NO_CONTENT);

		}
}

