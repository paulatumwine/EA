package cs544.hibernate04.associations;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
//@Embeddable
public class Pet {
	@Id
	@GeneratedValue
	private Long id;
	private int age;
	private String species;
	private String race;
	private String name;
	@ManyToOne
	@JoinColumn(name="Person_id", insertable=false, updatable=false)
	private Person owner;
}
