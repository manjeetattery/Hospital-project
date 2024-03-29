package com.example.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Doctor;

import jakarta.transaction.Transactional;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor, Long> {
	@Query(value = " SELECT doctor_patient_data.doctor_id FROM patient JOIN  doctor_patient_data ON patient.id=doctor_patient_data.patient_id WHERE doctor_patient_data.patient_id=:pId", nativeQuery = true)
	Long getDoctorIdByPatientId(@Param("pId") Long id);

	@Modifying
	@Transactional
	@Query(value = " UPDATE doctor_patient_data SET doctor_patient_data.doctor_id=:dId WHERE doctor_patient_data.patient_id=:pId", nativeQuery = true)
	void UpdateMapData(@Param("pId") Long id, @Param("dId") Long doctIds);
}
