package cs544.hibernate04.associations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	@OneToMany
	@JoinColumn(name="Person_id")
	@OrderColumn
	private List<Item> items = new ArrayList<>();
	
	
//	@OneToMany
//	@JoinColumn(name="owner_id")
//	@MapKeyColumn(name="name")
//	private Map<String, Pet> pets = new HashMap<>();
	
	
//	@OneToMany(mappedBy="owner")
//	private Collection<Marble> marbles = new ArrayList<>();
	
//	@JoinColumn
//	@JoinTable(name = "Customer_Car", 
//		joinColumns = { @JoinColumn(name = "customer_id") }, 
//		inverseJoinColumns = { 	@JoinColumn(name = "cars_id") }
//	)
//	@OneToMany(mappedBy="owner", orphanRemoval=true)
//	private List<Car> cars = new ArrayList<>();

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
//	public List<Car> getCars() {
//		return cars;
//	}
//
//	public void setCars(List<Car> cars) {
//		this.cars = cars;
//	}
//
//	public boolean addCar(Car car) {
//		if (cars.add(car)) {
//			car.setOwner(this);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean removeCar(Car car) {
//		if (cars.remove(car)) {
//			car.setOwner(null);
//			return true;
//		}
//		return false;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}