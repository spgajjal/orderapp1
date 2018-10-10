package com.capgemini.product.service;

import com.capgemini.product.entity.Product;
import com.capgemini.product.exception.ProductNotFoundException;

public interface ProductService {
	
	 public Product addProduct(Product product);

		public Product updateProduct(Product product);

		public Product findProductById(int productId) throws ProductNotFoundException;

		public void deleteProduct(Product product);

	}



	
	


