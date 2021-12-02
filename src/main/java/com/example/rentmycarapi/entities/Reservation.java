package com.example.rentmycarapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    private Listing listing;

    @Getter
    @Setter
    @ManyToOne
    private User buyer;

    @Getter
    @Setter
    private LocalDate startDate;

    @Getter
    @Setter
    private LocalDate endDate;

    public Reservation() {
    }

    public Reservation(Listing listing, User buyer, LocalDate startDate, LocalDate endDate) {
        this.listing = listing;
        this.buyer = buyer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
