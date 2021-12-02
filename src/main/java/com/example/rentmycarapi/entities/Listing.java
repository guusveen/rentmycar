package com.example.rentmycarapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    private Car car;

    @Getter
    @Setter
    @ManyToOne
    private User seller;

    @Getter
    @Setter
    private LocalDate startDate;

    @Getter
    @Setter
    private LocalDate endDate;

    @Getter
    @Setter
    private String location;

    public Listing() {
    }

    public Listing(Car car, User seller, LocalDate startDate, LocalDate endDate, String location) {
        this.car = car;
        this.seller = seller;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }
}
