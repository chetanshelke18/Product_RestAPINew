package com.jbk.serviceIMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public boolean saveProduct(Product product) {
		String productId = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
		product.setProductId(productId);
		boolean isSaved = dao.saveProduct(product);
		return isSaved;
	}

	@Override
	public Product getProductById(String productId) {
		return null;
		
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
		
	}

	@Override
	public boolean deleteProductById(String productId) {
		return false;
		
	}

	@Override
	public boolean updateProduct(Product product) {
		return false;
		
	}
	
}


