package com.healthtreat.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	
	private Long id;
	private String name;
	private int price;
	private int dcPrice;
	private String brand;
	private String thumbnail;
	private String description;
	private String descriptionImg;
	private char onSale;
	private int saleAmount;
	private int companyId;
	private int tagId;
	private LocalDateTime createdAt;
	private LocalDateTime revisedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDcPrice() {
		return dcPrice;
	}
	public void setDcPrice(int dcPrice) {
		this.dcPrice = dcPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionImg() {
		return descriptionImg;
	}
	public void setDescriptionImg(String descriptionImg) {
		this.descriptionImg = descriptionImg;
	}
	public char getOnSale() {
		return onSale;
	}
	public void setOnSale(char onSlae) {
		this.onSale = onSlae;
	}
	public int getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getRevisedAt() {
		return revisedAt;
	}
	public void setRevisedAt(LocalDateTime revisedAt) {
		this.revisedAt = revisedAt;
	}
	
	
}
