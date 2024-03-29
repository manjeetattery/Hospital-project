package com.example.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Hospital;

@Repository
public interface HospitalRepo extends CrudRepository<Hospital, Long> {
	@Modifying
	@Query(value = "DELETE rooms FROM hospital JOIN rooms ON hospital.id=rooms.hospital_id WHERE rooms.hospital_id=:i", nativeQuery = true)
	void deleteRoom(@Param("i") Long id);
@Modifying
	@Query(value = "DELETE doctor FROM hospital JOIN doctor ON doctor.hospital_id=hospital.id WHERE doctor.hospital_id=:i", nativeQuery = true)
	void deleteDoctor(@Param("i") Long id);

}
