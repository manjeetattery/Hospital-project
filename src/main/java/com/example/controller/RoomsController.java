package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.RoomsDTO;
import com.example.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomsController {
	@Autowired
	private RoomService roomService;

	@PostMapping("/save")
	public RoomsDTO saveRoom(@RequestBody RoomsDTO roomDto) {
		return roomService.saveRoom(roomDto);
	}

	@GetMapping("/get-by-id")
	public RoomsDTO getById(@RequestParam Long id) {
		return roomService.getById1(id);
	}

	@DeleteMapping("/delete-data-by-id")
	public RoomsDTO deleteData(@RequestParam Long id) {
		return roomService.deleteData(id);
	}

	@PutMapping("/update")
	public ResponseEntity<RoomsDTO> updateRoomData(@RequestBody RoomsDTO updatedRoomDto) {
		RoomsDTO updated = roomService.updateRoomById(updatedRoomDto);
		return ResponseEntity.ok(updated);
	}
}