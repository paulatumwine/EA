package cs544.hibernate04.associations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	@ManyToOne
	@JoinColumn(name="Person_id", insertable=false, updatable=false)
	private Person person;

}
