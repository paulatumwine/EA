package edu.mum.cs.springsecurityjsp.repository;


import edu.mum.cs.springsecurityjsp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
