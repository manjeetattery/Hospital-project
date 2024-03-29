package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.PatientDTO;
import com.example.dto.PatientDTO1;

@Service
public interface PatientService {

	PatientDTO1 saveData(PatientDTO patientDTO);

	PatientDTO getDataById(Long id);

	List<PatientDTO1> getDataByRoomId(Long id);

	PatientDTO1 deleteDataUsingId(Long id);

	List<PatientDTO1> getPatientByDoctorId(Long id);

	PatientDTO updatePatientData(PatientDTO updatePatientDTO);
}
