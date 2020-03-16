package edu.mum.cs.onetomanybitable;

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

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setPerson(this);
    }
}
