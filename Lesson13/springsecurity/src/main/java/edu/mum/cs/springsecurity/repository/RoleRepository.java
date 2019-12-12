package edu.mum.cs.springsecurity.repository;

import edu.mum.cs.springsecurity.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);

    List<Role> findAll();
}
