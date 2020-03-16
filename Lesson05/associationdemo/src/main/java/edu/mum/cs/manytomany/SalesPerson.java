package edu.mum.cs.manytomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
//@Entity
public class SalesPerson {
    @Id
    @GeneratedValue
    private Long id;
    private String alias;
    private String phoneNr;

    @ManyToMany
    @JoinTable
    private List<Customer> customers
            = new ArrayList<>();


}
