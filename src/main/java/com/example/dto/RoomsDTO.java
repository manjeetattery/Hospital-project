package com.example.dto;

public class RoomsDTO {
	private Long id;
	private String roomNumber;
	private Long hospitalId;

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

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "RoomsDTO [id=" + id + ", roomNumber=" + roomNumber + ", hospitalId=" + hospitalId + "]";
	}

	public RoomsDTO(Long id, String roomNumber, Long hospitalId) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.hospitalId = hospitalId;
	}

	public RoomsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}