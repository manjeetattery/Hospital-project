package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.RoomsDTO;

@Service
public interface RoomService {

	RoomsDTO saveRoom(RoomsDTO roomDto);

	RoomsDTO getById1(Long id);

	RoomsDTO deleteData(Long id);

	RoomsDTO updateRoomById(RoomsDTO updatedRoomDto);

}
