package com.example.rentmycarapi.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * A Reservation for a Listing
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Reservation {
    @Id
    @Getter
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

    /**
     * Empty constructor
     */
    public Reservation() {
    }

    /**
     * Constructor
     * @param listing
     * @param buyer
     * @param startDate
     * @param endDate
     */
    public Reservation(Listing listing, User buyer, LocalDate startDate, LocalDate endDate) {
        this.listing = listing;
        this.buyer = buyer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
