package com.healthtreat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.healthtreat.domain.ProductDTO;
import com.healthtreat.mapper.ProductMapper;

@SpringBootTest
public class ProductMapperTests {
	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void testOfInsert() {
		ProductDTO params = new ProductDTO();
		params.setName("마이밀 뉴프로틴바 식이섬유 고단백 간식 1박스");
		params.setPrice(20000);
		params.setDcPrice(11900);
		params.setBrand("대상웰라이프");
		params.setDescription("허기는 달래고 단백질과 식이섬유는 채우고 맛있는 고단백 간식");
		params.setOnSale('Y');
		params.setCompanyId(1);
		params.setTagId(1);
		
		int result = productMapper.registerProduct(params);
		System.out.println("결과는 " +result + "입니다.");
	}
	
	@Test
	public void testOfSelect() {
		ProductDTO product = productMapper.selectProductInfo((long) 5);
		System.out.println(product);
		try {
			String productJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(product);
			System.out.println("===============================");
			System.out.println(productJson);
			System.out.println("===============================");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOfUpdate() {
		ProductDTO params = new ProductDTO();
		params.setId((long) 5);
		params.setName("마이밀 뉴프로틴바 식이섬유 고단백 간식 1박스");
		params.setPrice(20000);
		params.setDcPrice(12000);
		params.setBrand("대상웰라이프");
		params.setDescription("허기는 달래고 단백질과 식이섬유는 채우고 맛있는 고단백 간식입니다. 마감임박");
		params.setOnSale('Y');
		params.setCompanyId(1);
		params.setTagId(1);
		
		int result = productMapper.updateProduct(params);
		if (result == 1) {
			ProductDTO product = productMapper.selectProductInfo((long) 5);
			try {
				String productJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(product);
				System.out.println("=========================");
				System.out.println(productJson);
				System.out.println("=========================");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testOfDelete() {
		int result = productMapper.deleteProduct((long) 4);
		if (result == 1) {
			ProductDTO product = productMapper.selectProductInfo((long) 4);
			try {
				String productJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(product);
				
				System.out.println("=================================");
				System.out.println(productJson);
				System.out.println("=================================");
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
}
