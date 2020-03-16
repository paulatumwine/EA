package edu.mum.cs.maytooneuni.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String model;
    private String maker;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer owner;

    public Car(int year, String model, String maker, Customer owner) {
        this.year = year;
        this.model = model;
        this.maker = maker;
        this.owner = owner;
    }
}
