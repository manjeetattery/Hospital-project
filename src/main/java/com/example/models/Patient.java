package com.example.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	private Rooms room;

	@ManyToMany(mappedBy = "patientList",cascade =CascadeType.ALL)
	private List<Doctor> doctorList;

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

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", room=" + room + ", doctorList=" + doctorList + "]";
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, String name, Rooms room, List<Doctor> doctorList) {
		super();
		this.id = id;
		this.name = name;
		this.room = room;
		this.doctorList = doctorList;
	}

}
