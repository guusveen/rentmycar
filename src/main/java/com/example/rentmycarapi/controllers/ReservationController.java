package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Reservation;
import com.example.rentmycarapi.repositories.ReservationRepository;
import com.example.rentmycarapi.services.ReservationService;
import org.springframework.web.bind.annotation.*;

/**
 * This is the RestController for accessing ReservationService methods
 */
@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {
    /**
     * Instance of ReservationService
     */
    private final ReservationService reservationService;

    /**
     * Constructor
     * @param reservationService
     */
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Gets all Reservations
     * @return
     */
    @GetMapping
    public Iterable<Reservation> getAll() {
        return reservationService.getAll();
    }

    /**
     * Get Reservation by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Reservation getById(@PathVariable long id) {
        return reservationService.getById(id);
    }

    /**
     * Create Reservation
     * @param reservation
     * @return
     */
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }
}
