package edu.mum.cs.onetomanyunijoincolumn;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
//@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToMany
    @JoinColumn
    private List<Car> cars = new ArrayList<>();

    public Person(String firstname, String lastname, List<Car> cars) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cars = cars;
    }
}
