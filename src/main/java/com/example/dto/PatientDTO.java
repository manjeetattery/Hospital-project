package com.example.dto;

public class PatientDTO {
	private Long id;
	private String name;
	private Long roomId;
	private Long doctIds;

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

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getDoctIds() {
		return doctIds;
	}

	public void setDoctIds(Long doctIds) {
		this.doctIds = doctIds;
	}

	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", name=" + name + ", roomId=" + roomId + ", doctIds=" + doctIds + "]";
	}

	public PatientDTO(Long id, String name, Long roomId, Long doctIds) {
		super();
		this.id = id;
		this.name = name;
		this.roomId = roomId;
		this.doctIds = doctIds;
	}

	public PatientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}