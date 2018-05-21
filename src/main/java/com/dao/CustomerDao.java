package com.dao;


import com.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Repository
public class CustomerDao {


    @PersistenceContext
    private EntityManager entityManager;


    @SuppressWarnings("unchecked")
    public List<Customer> getCustomerById(Integer id) {

        String hql="FROM Customer where id=?";
//        List<Customer> l = new ArrayList<>();
//        l = entityManager.createQuery(hql).setParameter(1,id).getResultList();
//        return l;
        return (List<Customer>) entityManager.createQuery(hql).setParameter(1,id).getResultList();
    }

    public List<Customer> getCustomerByEmailId(String email) {


        String hql = "FROM Customer WHERE email =  '" + email + "'";
        return (List<Customer>) entityManager.createQuery(hql)

                .getResultList();
    }

    public List<Customer> getCustomerBymobileNo(String mobileNo) {


        String hql = "FROM Customer WHERE mobileNo = ? ";
        return (List<Customer>) entityManager.createQuery(hql).setParameter(1, mobileNo)
                .getResultList();
    }

    public List<Customer> getCustomerByPin(Integer p) {


        String hql = "FROM Customer WHERE PIN=?";
        return (List<Customer>) entityManager.createQuery(hql).setParameter(1,p)
                .getResultList();
    }

    public List<Customer> getCustomerByName(String name){

        String hql="FROM Customer where name=?";
        return (List<Customer>) entityManager.createQuery(hql).setParameter(1,name).getResultList();
    }
    public List<Customer> getAllCustomer() {


        String hql = "FROM Customer ";
        return (List<Customer>) entityManager.createQuery(hql)
                .getResultList();
    }
}
