package com.healthtreat.service;

import com.healthtreat.domain.ProductDTO;

public interface ProductService {
	public boolean registerProduct(ProductDTO params);
	public ProductDTO selectProductInfo(Long id);
	public boolean deleteProduct(Long id);
}
