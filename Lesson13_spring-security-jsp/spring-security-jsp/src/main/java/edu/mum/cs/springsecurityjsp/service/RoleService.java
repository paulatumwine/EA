package edu.mum.cs.springsecurityjsp.service;


import edu.mum.cs.springsecurityjsp.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role get(Long id);
}
