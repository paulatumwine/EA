package edu.mum.cs.springsecurity.service;


import edu.mum.cs.springsecurity.model.Role;
import edu.mum.cs.springsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {

        return roleRepository.findAll();
    }

    @Override
    public Role get(Long id) {

        return roleRepository.findById(id).get();
    }

}
