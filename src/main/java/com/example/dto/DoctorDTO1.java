package com.example.dto;

import java.util.List;

public class DoctorDTO1 {
	private Long id;
	private Long docId;
	private List<Long> patientId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public List<Long> getPatientId() {
		return patientId;
	}

	public void setPatientId(List<Long> patientId) {
		this.patientId = patientId;
	}

	public DoctorDTO1(Long id, Long docId, List<Long> patientId) {
		super();
		this.id = id;
		this.docId = docId;
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "DoctorDto1 [id=" + id + ", docId=" + docId + ", patientId=" + patientId + "]";
	}

	public DoctorDTO1() {
		super();
		// TODO Auto-generated constructor stub
	}

}
