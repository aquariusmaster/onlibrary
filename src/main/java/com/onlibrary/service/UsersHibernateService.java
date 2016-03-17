package com.onlibrary.service;


import com.onlibrary.dao.UsersDao;
import com.onlibrary.entity.User;
import com.onlibrary.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by harkonnen on 15.03.16.
 */
@Service("usersService")
public class UsersHibernateService implements UsersService{

    @Autowired
    UsersDao usersDao;

    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    public void create(User user) {
        usersDao.create(user);
    }

    public void updateUser(User user) {

    }

    public User getUserById(int id) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }
}
