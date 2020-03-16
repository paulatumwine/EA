package cs544.hibernate04.associations;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

//@Entity
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	private short year;
	private String model;
	private String maker;
//	@JoinTable(name="Car_Customer")
//	@JoinColumn(name="customer_id")
//	@JoinTable
	@ManyToOne(cascade=CascadeType.DETACH)
	private Person owner;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(short year, String model, String maker, Person owner) {
		super();
		this.year = year;
		this.model = model;
		this.maker = maker;
//		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

}
