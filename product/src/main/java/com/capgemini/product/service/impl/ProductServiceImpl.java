package com.capgemini.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.product.entity.Product;
import com.capgemini.product.exception.ProductNotFoundException;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent())
			return optionalProduct.get();
		throw new ProductNotFoundException("Product does not exists");
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

}
