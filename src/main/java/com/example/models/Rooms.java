package com.example.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Rooms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roomNumber;
	@ManyToOne
	private Hospital hospital;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Patient> patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Rooms(Long id, String roomNumber, List<Patient> patient, Hospital hospital) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.patient = patient;
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", roomNumber=" + roomNumber + ", patient=" + patient + ", hospital=" + hospital
				+ "]";
	}

	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

}
