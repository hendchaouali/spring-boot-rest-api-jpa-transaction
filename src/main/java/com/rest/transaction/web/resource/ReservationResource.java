package com.rest.transaction.web.resource;

import com.rest.transaction.model.Reservation;
import com.rest.transaction.service.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ReservationResource {

    private final IReservationService reservationService;

    public ReservationResource(IReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/schedule")
    public ResponseEntity scheduleReservation(@Valid @RequestBody Reservation reservation){
        reservationService.scheduleReservation(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity cancelReservation(@Valid @RequestBody Reservation reservation){
        reservationService.cancelReservation(reservation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
