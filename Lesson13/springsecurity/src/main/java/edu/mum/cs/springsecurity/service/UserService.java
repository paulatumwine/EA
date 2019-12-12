package edu.mum.cs.springsecurity.service;

import edu.mum.cs.springsecurity.model.User;

public interface UserService {
    User saveUser(User user);

    User findUserByEmail(String email);
}
