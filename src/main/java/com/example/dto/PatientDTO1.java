package com.example.dto;

public class PatientDTO1 {
	private Long id;
	private String name;

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

	@Override
	public String toString() {
		return "PatientDTO1 [id=" + id + ", name=" + name + "]";
	}

	public PatientDTO1(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public PatientDTO1() {
		super();
		// TODO Auto-generated constructor stub
	}
}