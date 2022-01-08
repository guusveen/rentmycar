package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.Listing;
import com.example.rentmycarapi.entities.Reservation;
import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.entities.car.Car;
import com.example.rentmycarapi.entities.car.InternalCombustionEngine;
import com.example.rentmycarapi.enums.FuelType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DbInit {
    public DbInit(
            UserRepository userRepository,
            CarRepository carRepository,
            ListingRepository listingRepository,
            ReservationRepository reservationRepository
    ) {
        //users
        User guus = new User("Guus");
        User thijs = new User("Thijs");
        User erwin = new User("Erwin");

        userRepository.save(guus);
        userRepository.save(thijs);
        userRepository.save(erwin);

        //fuel
        FuelType petrol = FuelType.PETROL;
        FuelType gas = FuelType.GAS;

        //cars
        Car porsche = new InternalCombustionEngine(
                guus,
                "Porsche Carrera",
                "https://image.shutterstock.com/image-vector/ui-image-placeholder-wireframes-apps-260nw-1037719204.jpg",
                petrol
        );

        carRepository.save(porsche);

        //listings
        LocalDate listingStart1 = LocalDate.now();
        LocalDate listingEnd1 = LocalDate.now().plusDays(10);

        Listing porscheListing = new Listing(porsche, guus, listingStart1, listingEnd1, "Willem de Zwijgerweg 10, Best");

        listingRepository.save(porscheListing);

        //reservations
        LocalDate reservationStart1 = LocalDate.now();
        LocalDate reservationEnd1 = LocalDate.now().plusDays(3);

        Reservation porscheReservation = new Reservation(porscheListing, thijs, reservationStart1, reservationEnd1);

        reservationRepository.save(porscheReservation);
    }
}
