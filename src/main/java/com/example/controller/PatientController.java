package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PatientDTO;
import com.example.dto.PatientDTO1;
import com.example.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@PostMapping("/save")
	public PatientDTO1 savePatient(@RequestBody PatientDTO patientDTO) {
		return patientService.saveData(patientDTO);
	}

	@GetMapping("/get-by-id")
	public PatientDTO getDataById(@RequestParam Long id) {
		return patientService.getDataById(id);
	}

	@GetMapping("/get-by-room-id")
	public List<PatientDTO1> getDataByRoomId(@RequestParam Long id) {
		return patientService.getDataByRoomId(id);
	}

	@DeleteMapping("/delete-by-id")
	public PatientDTO1 deleteData(@RequestParam Long id) {
		PatientDTO1 patientDto1 = patientService.deleteDataUsingId(id);
		return patientDto1;
	}

	@GetMapping("/get-patient-doctor-id")
	public List<PatientDTO1> getPatientByDoctorId(@RequestParam Long id) {
		return patientService.getPatientByDoctorId(id);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updatePatientData(@RequestBody PatientDTO UpdatePatientDTO) {
		PatientDTO updated = patientService.updatePatientData(UpdatePatientDTO);
		return ResponseEntity.ok("Room with ID " + updated.getId() + " updated successfully.");
	}
}