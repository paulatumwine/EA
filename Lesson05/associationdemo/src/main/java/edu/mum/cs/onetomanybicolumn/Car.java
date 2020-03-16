package edu.mum.cs.onetomanybicolumn;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    public Car(int year, String model, String maker) {
        this.year = year;
        this.model = model;
        this.maker = maker;
    }
}
