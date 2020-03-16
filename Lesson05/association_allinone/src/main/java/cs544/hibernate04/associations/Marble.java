package cs544.hibernate04.associations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class Marble {
	@Id
	@GeneratedValue
	private Long id;
	private int size;
	private String color;
	@ManyToOne
	private Person owner;
}
