package edu.mum.cs.springsecurity.service;


import edu.mum.cs.springsecurity.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role get(Long id);
}
