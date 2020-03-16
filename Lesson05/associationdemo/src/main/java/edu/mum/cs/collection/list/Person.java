package edu.mum.cs.collection.list;

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
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    @OneToMany
    @JoinColumn(name="Person_id")
    @OrderColumn(name="sequence")
    private List<Item> items
            = new ArrayList<>();

}
