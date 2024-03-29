package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Rooms;

@Repository
public interface RoomRepo extends CrudRepository<Rooms, Long> {

}
