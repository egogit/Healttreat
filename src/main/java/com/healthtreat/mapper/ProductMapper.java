package com.healthtreat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.healthtreat.domain.ProductDTO;

@Mapper
public interface ProductMapper {
	public int registerProduct(ProductDTO params);
	public ProductDTO selectProductInfo(Long id);
	public int updateProduct(ProductDTO params);
	public int deleteProduct(Long id);
//	public List<ProductDTO> selectProductList();
//	public int selectProductTotalCount();
}
