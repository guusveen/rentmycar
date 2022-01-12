package com.example.rentmycarapi.entities.car;

import com.example.rentmycarapi.entities.Listing;
import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.interfaces.Costs;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * This is the base class for InternalCombustionEngine and ElectricalVehicle Cars
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public abstract class Car implements Costs {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    private User owner;

    @Getter
    @Setter
    private String model;

    @Getter
    @Setter
    private String picture;

    @Getter
    @Setter
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listing> listings;

    /**
     * Empty constructor
     */
    public Car() {
    }

    /**
     * Constructor
     * @param owner
     * @param model
     * @param picture
     */
    public Car(User owner, String model, String picture) {
        this.owner = owner;
        this.model = model;
        this.picture = picture;
    }
}
