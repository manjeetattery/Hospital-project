package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.HospitalDTO;

@Service
public interface HospitalService {

	HospitalDTO saveData(HospitalDTO dto);

	HospitalDTO getById(Long id);

	HospitalDTO deleteById(Long id);

	HospitalDTO updateHospitalById(HospitalDTO updatedHospital);

}
