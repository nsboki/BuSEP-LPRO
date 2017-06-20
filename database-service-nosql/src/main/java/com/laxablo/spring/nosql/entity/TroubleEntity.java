package com.laxablo.spring.nosql.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lax_trouble")
public class TroubleEntity {
	
	@Id
	private String id;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String product;
	private String trouble;
	private List<String> pictures = new ArrayList<String>();
	
	public TroubleEntity(String product, String trouble, List<String> pictures) {
		super();
		this.product = product;
		this.trouble = trouble;
		this.pictures = pictures;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTrouble() {
		return trouble;
	}
	public void setTrouble(String trouble) {
		this.trouble = trouble;
	}
	public List<String> getPictures() {
		return pictures;
	}
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	
}
