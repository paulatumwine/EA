package cs544.hibernate04.associations;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

//@Entity
public class ToolBox {
	@Id
	@GeneratedValue
	private Long id;
	private String model;
	private String manufacturer;
	@OneToMany(mappedBy="owner")
	@OrderBy("size ASC")
	private Set<Tool> tools = new HashSet<>();

}
