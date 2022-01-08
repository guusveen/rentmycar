package com.example.rentmycarapi.entities;

import com.example.rentmycarapi.entities.car.Car;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Listing {
    @Id
    @Getter
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

    @Getter
    @Setter
    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

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
