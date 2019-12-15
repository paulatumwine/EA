package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class FsEndpoint {
	@Autowired
	private PersonService personService;

	@ServiceActivator(inputChannel = "personChannel")
	public void getPerson(Person p) {
		if (p.getId() == null) {
			personService.add(p);
		} else {
			personService.update(p);
		}
		System.out.println(personService.getAll());
	}
}