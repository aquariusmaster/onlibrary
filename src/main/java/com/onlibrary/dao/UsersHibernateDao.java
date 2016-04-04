package com.onlibrary.dao;

/**
 * Created by harkonnen on 15.03.16.
 */
import java.util.List;

import javax.sql.DataSource;

import com.onlibrary.entity.User;
import com.onlibrary.dao.UsersDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("usersDao")
public class UsersHibernateDao implements UsersDao {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SessionFactory sessionFactory;



    @Transactional
    public void create(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.sessionFactory.getCurrentSession().save(user);
    }
    @Transactional
    public boolean exists(String username) {
        Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        crit.add(Restrictions.idEq(username));
        User user = (User)crit.uniqueResult();
        return user != null;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getAllUsers() {
        return this.sessionFactory.getCurrentSession().createQuery("from User").list();
    }


    @Transactional
    public void updateUser(User user) {

    }
    @Transactional
    public User getUserById(int id) {
        return null;
    }
    @Transactional
    public User getUserByEmail(String email) {
        return null;
    }

}
