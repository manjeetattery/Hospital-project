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

import com.example.dto.HospitalDTO;
import com.example.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@PostMapping("/save")
	public HospitalDTO saveData(@RequestBody HospitalDTO dto) {
		return hospitalService.saveData(dto);
	}

	@GetMapping("/get-by-id")
	public HospitalDTO getById(@RequestParam Long id) {
		return hospitalService.getById(id);
	}

	@DeleteMapping("/delete-by-id")
	public HospitalDTO deleteById(@RequestParam Long id) {
		return hospitalService.deleteById(id);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateHospitalData(@RequestBody HospitalDTO updatedHospital) {
		HospitalDTO updated = hospitalService.updateHospitalById(updatedHospital);
		return ResponseEntity.ok("Hospital with ID " + updated + " updated successfully.");
	}
}