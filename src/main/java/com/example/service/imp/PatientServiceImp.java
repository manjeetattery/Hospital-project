package com.example.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PatientDTO;
import com.example.dto.PatientDTO1;
import com.example.excption.UserNotFoundException;
import com.example.models.Doctor;
import com.example.models.Hospital;
import com.example.models.Patient;
import com.example.models.Rooms;
import com.example.repo.DoctorRepo;
import com.example.repo.PatientRepo;
import com.example.repo.RoomRepo;
import com.example.service.PatientService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientServiceImp implements PatientService {
	@Autowired
	private PatientRepo patientRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private DoctorRepo docRepo;
	@Autowired
	private RoomRepo repo;

	@Override
	public PatientDTO1 saveData(PatientDTO patientDTO) {
		/*
		 * Long docId1 = patientDTO.getDoctIds(); Long roomId = patientDTO.getRoomId();
		 * boolean exitDoctorId = docRepo.existsById(docId1); boolean exitRoomId =
		 * repo.existsById(roomId); boolean exit = true; if (exitRoomId == exit) { if
		 * (exitDoctorId == exit) {
		 */
		Rooms room1 = repo.findById(patientDTO.getRoomId())
				.orElseThrow(() -> new UserNotFoundException("Room not found with ID: " + patientDTO.getRoomId()));
		Hospital hospital1 = room1.getHospital();
		Doctor doctor1 = docRepo.findById(patientDTO.getDoctIds())
				.orElseThrow(() -> new UserNotFoundException("doctor not found with ID: " + patientDTO.getDoctIds()));
		Hospital hospital2 = doctor1.getHospital();
		if (!hospital1.getId().equals(hospital2.getId())) {
			throw new UserNotFoundException("doctor is not in same in hospital");
		}

		Patient patient = new Patient();
		patient.setName(patientDTO.getName());
		Rooms rom = repo.findById(patientDTO.getRoomId())
				.orElseThrow(() -> new UserNotFoundException("hospital not found with ID: " + patientDTO.getRoomId()));
		patient.setRoom(rom);
		/*
		 * RoomsDTO dto = roomServiceImp.getById1(patientDTO.getRoomId()); Rooms rooms =
		 * mapper.map(dto, Rooms.class); patient.setRoom(rooms);
		 */
//		List<Doctor> docList = new ArrayList<Doctor>();
		// List<Doctor> docList = new ArrayList<Doctor>();
		Long docId = patientDTO.getDoctIds();
		Doctor doc = docRepo.findById(docId)
				.orElseThrow(() -> new UserNotFoundException("doctor not found with ID: " + docId));
		doc.getPatientList().add(patient);
		Patient patient1 = patientRepo.save(patient);
		PatientDTO1 patientDto1 = mapper.map(patient1, PatientDTO1.class);
		return patientDto1;

		/*
		 * } else { throw new ResourceNotFoundException("Doctor not found by id "); }
		 */
		/*
		 * } else { throw new ResourceNotFoundException("room not found by id "); }
		 */
	}

	@Override
	public PatientDTO getDataById(Long id) {
		// TODO Auto-generated method stub
		Patient p = patientRepo.findById(id).get();
		PatientDTO dto = mapper.map(p, PatientDTO.class);
		return dto;
	}

	@Override
	public List<PatientDTO1> getDataByRoomId(Long id) {
		// TODO Auto-generated method stub
		List<Patient> patientList = patientRepo.getDataByRoomId(id);
		List<PatientDTO1> patientDtoList = patientList.stream().map(user -> mapper.map(user, PatientDTO1.class))
				.collect(Collectors.toList());
		return patientDtoList;
	}

	@Override
	public PatientDTO1 deleteDataUsingId(Long id) {
		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("doctor not found with ID: " + id));
		PatientDTO1 patientDto1 = mapper.map(patient, PatientDTO1.class);
		patientRepo.deleteDoctorId(patientDto1.getId());
		patientRepo.deleteByPatientId(patientDto1.getId());
		return patientDto1;
	}

	@Override
	public List<PatientDTO1> getPatientByDoctorId(Long id) {
		// TODO Auto-generated method stub
		List<Patient> patientList = patientRepo.getPatientByDocId(id);
		List<PatientDTO1> patientDtoList = patientList.stream().map(user -> mapper.map(user, PatientDTO1.class))
				.collect(Collectors.toList());
		return patientDtoList;
	}

	@Override
	public PatientDTO updatePatientData(PatientDTO updatePatientDTO) {
		// TODO Auto-generated method stub

		Rooms room1 = repo.findById(updatePatientDTO.getRoomId()).orElseThrow(
				() -> new EntityNotFoundException("Room not found with ID: " + updatePatientDTO.getRoomId()));
		Hospital hospital1 = room1.getHospital();
		Doctor doctor1 = docRepo.findById(updatePatientDTO.getDoctIds()).orElseThrow(
				() -> new EntityNotFoundException("doctor not found with ID: " + updatePatientDTO.getDoctIds()));
		Hospital hospital2 = doctor1.getHospital();

		if (!hospital1.getId().equals(hospital2.getId())) {
			throw new UserNotFoundException("doctor is not in same in hospital");
		}
		Patient existingPatient = patientRepo.findById(updatePatientDTO.getId()).orElseThrow(
				() -> new EntityNotFoundException("Product not found with ID: " + updatePatientDTO.getId()));
		existingPatient.setName(updatePatientDTO.getName());
		Rooms rom = repo.findById(room1.getId()).orElseThrow(
				() -> new EntityNotFoundException("room not found with ID: " + updatePatientDTO.getRoomId()));
		existingPatient.setRoom(rom);
		docRepo.UpdateMapData(existingPatient.getId(), updatePatientDTO.getDoctIds());
		Patient p = patientRepo.save(existingPatient);
		mapper.map(p, PatientDTO.class);

		return updatePatientDTO;
	}
}
