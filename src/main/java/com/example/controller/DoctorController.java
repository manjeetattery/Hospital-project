package com.example.controller;

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

import com.example.dto.DoctorDTO;
import com.example.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/save")
	public DoctorDTO saveDoctor(@RequestBody DoctorDTO doctorDTO) {
		return doctorService.saveDoctor(doctorDTO);
	}

	@GetMapping("/get-by-id")
	public DoctorDTO getDocById(@RequestParam Long id) {
		return doctorService.getDocById(id);
	}

	@GetMapping("/get-doctor-by-patient-id")
	public DoctorDTO getDoctorByPatientId(@RequestParam Long id) {
		return doctorService.getDoctorByPatientId(id);
	}

	@DeleteMapping("/delete")
	public DoctorDTO deleteById(@RequestParam Long id) {
		return doctorService.deleteById(id);
	}

	@PutMapping("/update")
	public ResponseEntity<DoctorDTO> updateProduct(@RequestBody DoctorDTO doctorDTO) {
		DoctorDTO dto = doctorService.updateDoctorById(doctorDTO);
		return ResponseEntity.ok(dto);
	}
}