package com.masai.service;
import java.util.List;
import java.util.Optional;

import com.masai.model.User;

public interface UserService {

   public List<User> getAllUsers();

    public User getUserById(Long userId);

    public User createUser(User user);

    public User deleteUser(Long userId);
}

