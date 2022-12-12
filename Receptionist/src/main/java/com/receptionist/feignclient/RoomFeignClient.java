package com.receptionist.feignclient;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.receptionist.exception.RoomNotFoundException;
import com.receptionist.model.Room;


@FeignClient(name = "room-serviceRoom-Service", url = "http://localhost:3002/room")
public interface RoomFeignClient {

	@GetMapping("/all")
	public ResponseEntity<List<Room>> showAllRoom();

	@GetMapping("/{id}")
	public ResponseEntity<Room> showById(@PathVariable("id") int id) throws RoomNotFoundException;

	@PostMapping("/addroom")
	public ResponseEntity<Room> addRoomDetails(@RequestBody Room roomDetails) throws RoomNotFoundException;

	@PutMapping("/updateroom")
	public ResponseEntity<Room> updateRoomDetails(@RequestBody Room roomDetails) throws RoomNotFoundException;

	@DeleteMapping("/deleteroom/{id}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable("id") int id) throws RoomNotFoundException;

}
