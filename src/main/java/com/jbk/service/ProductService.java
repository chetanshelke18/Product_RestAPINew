package com.jbk.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.jbk.entity.Product;

public interface ProductService {
	
	public boolean saveProduct(Product product);
	public Product getProductById(String productId);
	public List<Product> getAllProducts();
	public boolean deleteProductById(String productId);
	public boolean updateProduct(Product product);
	public List<Product> sortProductsById_ASC();
	public List<Product> sortProductsByName_DESC();
	public double getMaxPrice();
	public double countSumOfProductsPrice();
	public int getTotalCountOfProducts();
	public List<Product> getMaxPriceProducts();
	public String upploadSheet(MultipartFile file);
	
	}


