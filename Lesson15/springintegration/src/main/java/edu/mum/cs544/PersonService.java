package edu.mum.cs544;

import java.util.List;

public interface PersonService {
	Person get(Long id);
	List<Person> getAll();
	Long add(Person p);
	void update(Person p);
	void delete(Long id);
}
