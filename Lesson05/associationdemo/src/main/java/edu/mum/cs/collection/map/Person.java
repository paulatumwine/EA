package edu.mum.cs.collection.map;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
//@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    @OneToMany
    @JoinColumn(name="Person_id")
    @MapKeyColumn(name="name")
    private Map<String, Pet> pets
            = new HashMap<>();


}
