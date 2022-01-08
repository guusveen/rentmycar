package com.example.rentmycarapi.entities.car;

import com.example.rentmycarapi.entities.User;
import com.example.rentmycarapi.interfaces.Costs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public abstract class Car implements Costs {
    @Getter
    @Id
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

    public Car() {
    }

    public Car(User owner, String model, String picture) {
        this.owner = owner;
        this.model = model;
        this.picture = picture;
    }
}
