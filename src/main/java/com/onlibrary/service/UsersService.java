package com.onlibrary.service;

import com.onlibrary.entity.User;

import java.util.List;

/**
 * Created by harkonnen on 17.03.16.
 */
public interface UsersService {
    List<User> getAllUsers();

    void create(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByEmail(String email);

    boolean exists(String username);
}
