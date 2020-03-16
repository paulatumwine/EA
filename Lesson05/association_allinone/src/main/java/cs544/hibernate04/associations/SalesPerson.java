package cs544.hibernate04.associations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//@Entity
public class SalesPerson {
	@Id
	@GeneratedValue
	private Long id;
	private String alias;
	private String phoneNr;
	@ManyToMany
	private List<Customer> customers = new ArrayList<>();

}
