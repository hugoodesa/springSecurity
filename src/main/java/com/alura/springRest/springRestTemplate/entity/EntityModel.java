package com.alura.springRest.springRestTemplate.entity;

public abstract class  EntityModel {

	private Long id;

	public EntityModel() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
