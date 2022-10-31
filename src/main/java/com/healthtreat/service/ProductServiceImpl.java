package com.healthtreat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthtreat.domain.ProductDTO;
import com.healthtreat.mapper.ProductMapper;

@Service

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public boolean registerProduct(ProductDTO params) {
		int queryResult = 0;
		
		if (params.getId() == null) {
			queryResult = productMapper.registerProduct(params);
		} else {
			queryResult = productMapper.updateProduct(params);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public ProductDTO selectProductInfo(Long id) {
		return productMapper.selectProductInfo(id);
	}

	@Override
	public boolean deleteProduct(Long id) {
		int queryResult = 0;
		
		ProductDTO product = productMapper.selectProductInfo(id);
		if (product != null) {
			queryResult = productMapper.deleteProduct(id);
		}
		
		return (queryResult == 1) ? true : false;
	}

}
