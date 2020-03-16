package edu.mum.cs.onetomanyunijoincolumn;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Car(int year, String model, String maker) {
        this.year = year;
        this.model = model;
        this.maker = maker;
    }
}
