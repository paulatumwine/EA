package edu.mum.cs.manytoonejointable.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private int year;
    private String model;
    private String maker;
    @ManyToOne
    @JoinTable(name="car_customer",
            joinColumns = { @JoinColumn(name = "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "cars_id") }
    )
    private Customer owner;

    public Car(int year, String model, String maker, Customer owner) {
        this.year = year;
        this.model = model;
        this.maker = maker;
        this.owner = owner;
    }
}
