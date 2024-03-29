package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.DoctorDTO;

@Service
public interface DoctorService {

	DoctorDTO saveDoctor(DoctorDTO doctorDTO);

	DoctorDTO getDocById(Long id);

	DoctorDTO getDoctorByPatientId(Long id);

	DoctorDTO deleteById(Long id);

	DoctorDTO updateDoctorById(DoctorDTO doctorDTO);

}
