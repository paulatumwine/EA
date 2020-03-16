package edu.mum.cs.onetomanyunijointable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private List<Car> cars = new ArrayList<>();

    public Person(String firstname, String lastname, List<Car> cars) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cars = cars;
    }
}
