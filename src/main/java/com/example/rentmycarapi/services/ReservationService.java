package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.Reservation;

public interface ReservationService {
    Iterable<Reservation> getAll();
    Reservation getById(Long id);

    Reservation createReservation(Reservation reservation);
}
