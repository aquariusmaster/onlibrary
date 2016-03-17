package com.onlibrary.dao;

import com.onlibrary.entity.User;

import java.util.List;

/**
 * Created by harkonnen on 17.03.16.
 */
public interface UsersDao {

    List<User> getAllUsers();

    void create(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByEmail(String email);
}
