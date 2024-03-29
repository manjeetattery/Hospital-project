package com.example.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.RoomsDTO;
import com.example.excption.UserNotFoundException;
import com.example.models.Hospital;
import com.example.models.Rooms;
import com.example.repo.HospitalRepo;
import com.example.repo.RoomRepo;
import com.example.service.RoomService;

@Service
public class RoomServiceImp implements RoomService {
	@Autowired
	private RoomRepo roomRepo;
	@Autowired
	private HospitalRepo hospitalRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public RoomsDTO saveRoom(RoomsDTO roomDto) {
		Rooms rooms = new Rooms();
		rooms.setRoomNumber(roomDto.getRoomNumber());
		Long id = roomDto.getHospitalId();
		System.out.println("id:  " + id);
		Hospital hospital = hospitalRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("hospital not found with ID: " + id));
		rooms.setHospital(hospital);
		Rooms room = roomRepo.save(rooms);
		RoomsDTO roomDto1 = mapper.map(room, RoomsDTO.class);
		return roomDto1;
	}

	@Override
	public RoomsDTO getById1(Long id) {
		Rooms rooms = roomRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Room not found with ID: " + id));
		RoomsDTO roomsDto = mapper.map(rooms, RoomsDTO.class);
		return roomsDto;
	}

	@Override
	public RoomsDTO deleteData(Long id) {
		Rooms room = roomRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Room id " + id + " not exit."));
		RoomsDTO roomsDto = mapper.map(room, RoomsDTO.class);
		roomRepo.deleteById(room.getId());
		return roomsDto;
	}

	@Override
	public RoomsDTO updateRoomById(RoomsDTO updatedRoomDto) {
		Rooms existingRoom = roomRepo.findById(updatedRoomDto.getId())
				.orElseThrow(() -> new UserNotFoundException("Room not found with ID: " + updatedRoomDto.getId()));
		existingRoom.setRoomNumber(updatedRoomDto.getRoomNumber());


		Rooms room = roomRepo.save(existingRoom);
		RoomsDTO roomDto = mapper.map(room, RoomsDTO.class);
		return roomDto;
	}
}