package com.example.dto;

public class HospitalDTO {
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
		return "HospitalDTO [id=" + id + ", name=" + name + "]";
	}

	public HospitalDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public HospitalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}