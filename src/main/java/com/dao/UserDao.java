package com.dao;


import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Transactional
@Repository

public class UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @SuppressWarnings("unchecked")

    public List<User> getUserByEmailId(String email) {


        String hql = "FROM User WHERE email =  '" + email + "'";
        return (List<User>) entityManager.createQuery(hql)
                .getResultList();
    }

    public List<User> getUserByName(String name) {


        String hql = "FROM User WHERE name = ? ";
        return (List<User>) entityManager.createQuery(hql).setParameter(1, name)
                .getResultList();
    }
}
