package com.example.dto;

public class DoctorDTO {
	private Long id;
	private String doctorName;
	private Long hospitalId;

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

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "DoctorDTO [id=" + id + ", doctorName=" + doctorName + ", hospitalId=" + hospitalId + "]";
	}

	public DoctorDTO(Long id, String doctorName, Long hospitalId) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.hospitalId = hospitalId;
	}

	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}