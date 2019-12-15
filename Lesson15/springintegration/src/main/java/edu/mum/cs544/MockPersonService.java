package edu.mum.cs544;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MockPersonService implements PersonService {
	private Map<Long, Person> ppl = new HashMap<>();
	private long next = 1;

	public MockPersonService() {
		add(new Person("Test", 28));
	}

	@Override
	public Person get(Long id) {
		return ppl.get(id);
	}

	@Override
	public List<Person> getAll() {
		return new ArrayList<Person>(ppl.values());
	}

	@Override
	public Long add(Person p) {
		long id = next;
		p.setId(id);
		ppl.put(id, p);
		next += 1;
		return id;
	}

	@Override
	public void update(Person p) {
		ppl.put(p.getId(), p);
	}

	@Override
	public void delete(Long id) {
		ppl.remove(id);
	}

}
