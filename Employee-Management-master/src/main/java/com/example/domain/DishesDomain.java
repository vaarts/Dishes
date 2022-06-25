package com.example.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class DishesDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String type;
	
	private List<String> ingredients;
	
	public DishesDomain() {
		// TODO Auto-generated constructor stub
	}

	public DishesDomain(int id, String name, String type, List<String> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "DishesDomain [id=" + id + ", name=" + name + ", type=" + type + ", ingredients=" + ingredients + "]";
	}
	
	

	
}
