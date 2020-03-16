package edu.mum.cs.onetomanybitable;

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
    @JoinTable(name = "car_person_bitable")
    private Person person;

    public Car(int year, String model, String maker) {
        this.year = year;
        this.model = model;
        this.maker = maker;
    }
}
