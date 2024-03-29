package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Patient;

import jakarta.transaction.Transactional;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Long> {
	@Query(value = "SELECT p.* FROM rooms r JOIN patient p ON p.room_id=r.id WHERE p.room_id=:i", nativeQuery = true)
	List<Patient> getDataByRoomId(@Param("i") Long id);

	@Query(value = "SELECT patient.* FROM doctor_patient_data JOIN patient ON doctor_patient_data.patient_id=patient.id  WHERE doctor_patient_data.doctor_id=:id", nativeQuery = true)
	List<Patient> getPatientByDocId(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "DELETE doctor_patient_data FROM doctor_patient_data WHERE doctor_patient_data.patient_id=:pId", nativeQuery = true)
	void deleteDoctorId(@Param("pId") Long id);

	@Modifying
	@Transactional
	@Query(value = "DELETE patient FROM patient WHERE patient.id=:pId", nativeQuery = true)
	void deleteByPatientId(@Param("pId") Long id);
}
