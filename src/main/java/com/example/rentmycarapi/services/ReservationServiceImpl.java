package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.Reservation;
import com.example.rentmycarapi.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

/**
 * This class implements the methods of ReservationService
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Iterable<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
