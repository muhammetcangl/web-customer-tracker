package com.mcg.springdemo.dao;

import com.mcg.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query ... sort by last name
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();

        //###############################################################################
        // saveOrUpdate methodu sayesinde id si olan bir nesne gelirse guncelleme,
        // id'si bos olan bir nesne gelirse yeni bir kayıt islemi yapilir.
        //###############################################################################

        currentSession.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Customer where id=:customerId");

        query.setParameter("customerId" , id);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);
        }

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;

    }


}
