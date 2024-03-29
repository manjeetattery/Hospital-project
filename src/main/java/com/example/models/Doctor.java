package com.example.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String doctorName;

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_patient_data", joinColumns = @JoinColumn(name = "Doctor_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patientList;

	@ManyToOne(fetch = FetchType.LAZY)
	private Hospital hospital;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorName=" + doctorName + ", patientList=" + patientList + ", hospital="
				+ hospital + "]";
	}

	public Doctor(Long id, String doctorName, List<Patient> patientList, Hospital hospital) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.patientList = patientList;
		this.hospital = hospital;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
