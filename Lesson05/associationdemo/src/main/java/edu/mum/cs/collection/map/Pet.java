package edu.mum.cs.collection.map;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
//@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;
    private String species;
    private String race;
//    private String name;
   /* @ManyToOne
    @JoinColumn(name = "Person_id", insertable = false, updatable = false)
    private Person owner;*/
}
