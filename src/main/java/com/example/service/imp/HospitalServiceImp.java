package com.example.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.HospitalDTO;
import com.example.excption.UserNotFoundException;
import com.example.models.Hospital;
import com.example.repo.HospitalRepo;
import com.example.service.HospitalService;

@Service
public class HospitalServiceImp implements HospitalService {
	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public HospitalDTO saveData(HospitalDTO dto) {
		Hospital h1 = new Hospital();
		h1.setName(dto.getName());
		Hospital hospital = hospitalRepo.save(h1);
		HospitalDTO hospitalDto = mapper.map(hospital, HospitalDTO.class);
		return hospitalDto;
	}

	@Override
	public HospitalDTO getById(Long id) {
		Hospital hospital = hospitalRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("hospital not found with ID: " + id));
		HospitalDTO dto = mapper.map(hospital, HospitalDTO.class);
		return dto;
	}

	@Override
	public HospitalDTO deleteById(Long id) {
		Hospital hospital = hospitalRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("room id  " + id + "  not exit"));
		HospitalDTO hospitalDto = mapper.map(hospital, HospitalDTO.class);
		hospitalRepo.deleteById(id);
		return hospitalDto;
	}

	@Override
	public HospitalDTO updateHospitalById(HospitalDTO updatedHospital) {
		// TODO Auto-generated method stub
		Hospital existingHospital = hospitalRepo.findById(updatedHospital.getId())
				.orElseThrow(() -> new UserNotFoundException("hospital not found with ID: " + updatedHospital.getId()));
		existingHospital.setName(updatedHospital.getName());
		Hospital hospital = hospitalRepo.save(existingHospital);
		HospitalDTO dto = mapper.map(hospital, HospitalDTO.class);
		return dto;
	}
}