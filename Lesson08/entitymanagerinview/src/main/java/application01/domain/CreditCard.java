package application01.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	private String name;

	@OneToOne
	private Customer customer;

	@OneToOne
	private Address address;

	public CreditCard(String number, String name, Customer customer, Address address) {
		super();
		this.number = number;
		this.name = name;
		this.customer = customer;
		this.address = address;
	}

}
