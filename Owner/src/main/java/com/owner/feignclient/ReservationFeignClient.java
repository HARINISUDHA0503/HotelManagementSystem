package com.owner.feignclient;

import java.util.List;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.owner.exception.ReservationNotFoundException;
import com.owner.model.Reservation;


@FeignClient(name = "reservation-service", url = "http://localhost:3004/reservation")
public interface ReservationFeignClient {

	@GetMapping("/all")
	public ResponseEntity<List<Reservation>> showAllReservation();

	@GetMapping("/{id}")
	public ResponseEntity<Reservation> showById(@PathVariable("id") int id) 
			throws ReservationNotFoundException;

	@PostMapping("/addreservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation)
			throws ReservationNotFoundException;

	@PutMapping("/updatereservation")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation)
			throws ReservationNotFoundException;

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteReservation(@PathVariable("id") int id) throws ReservationNotFoundException;

}
