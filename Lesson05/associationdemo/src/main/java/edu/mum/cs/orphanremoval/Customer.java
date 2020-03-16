package edu.mum.cs.orphanremoval;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rxing
 */

//@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "cust", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditCard> cards = new ArrayList<>();
    
    
    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addCard(CreditCard card) {
        this.cards.add(card);
        card.setCust(this);
    }
    
    public void removeCard(CreditCard card) {
        this.cards.remove(card);
        card.setCust(null);
    }
}
