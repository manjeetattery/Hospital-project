package com.example.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DoctorDTO;
import com.example.excption.UserNotFoundException;
import com.example.models.Doctor;
import com.example.models.Hospital;
import com.example.repo.DoctorRepo;
import com.example.repo.HospitalRepo;
import com.example.service.DoctorService;

@Service
public class DoctorServiceImp implements DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private HospitalRepo hospitalRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		Doctor doc = new Doctor();
		doc.setDoctorName(doctorDTO.getDoctorName());

		Hospital h = hospitalRepo.findById(doctorDTO.getHospitalId()).orElseThrow(
				() -> new UserNotFoundException("hospital not found with ID: " + doctorDTO.getHospitalId()));
		doc.setHospital(h);
		Doctor d = doctorRepo.save(doc);
		DoctorDTO docDto = mapper.map(d, DoctorDTO.class);
		return docDto;
	}

	@Override
	public DoctorDTO getDocById(Long id) {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("doctor not found with ID: " + id));
		DoctorDTO dto = mapper.map(doc, DoctorDTO.class);
		return dto;
	}

	@Override
	public DoctorDTO getDoctorByPatientId(Long id) {
		// TODO Auto-generated method stub
		Long id1 = doctorRepo.getDoctorIdByPatientId(id);
		DoctorDTO dto = getDocById(id1);
		return dto;
	}

	@Override
	public DoctorDTO deleteById(Long id) {
		// TODO Auto-generated method stub
		Doctor doctor = doctorRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("doctor id  " + id + " is not exit."));
		DoctorDTO dto = mapper.map(doctor, DoctorDTO.class);
		doctorRepo.deleteById(dto.getId());
		return dto;
	}

	@Override
	public DoctorDTO updateDoctorById(DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		Doctor existingDoctor = doctorRepo.findById(doctorDTO.getId())
				.orElseThrow(() -> new UserNotFoundException("Product not found with ID: " + doctorDTO.getId()));

		// Update the fields you want (e.g., name, price, etc.)
		existingDoctor.setDoctorName(doctorDTO.getDoctorName());

		Hospital hospital = hospitalRepo.findById(doctorDTO.getHospitalId()).get();
		existingDoctor.setHospital(hospital);

		// Save the updated product
		Doctor docDto = doctorRepo.save(existingDoctor);
		DoctorDTO dto = mapper.map(docDto, DoctorDTO.class);
		return dto;

	}
}