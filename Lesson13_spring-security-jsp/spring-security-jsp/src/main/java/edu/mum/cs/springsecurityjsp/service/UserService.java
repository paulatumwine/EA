package edu.mum.cs.springsecurityjsp.service;


import edu.mum.cs.springsecurityjsp.model.User;

public interface UserService {
    User saveUser(User user);

    User findUserByEmail(String email);
}
