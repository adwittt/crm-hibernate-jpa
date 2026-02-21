package main;

import entity.Customer;
import entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JPAUtil;

public class TestApp {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Address address = new Address();
        address.setStreet("MG Road");
        address.setCity("Pune");
        address.setState("MH");
        address.setZipCode("411001");

        Customer customer = new Customer();
        customer.setName("Adwit");
        customer.setEmail("adwit@gmail.com");
        customer.setPhone("9999999999");
        customer.setAddress(address);

        em.persist(customer);

        tx.commit();
        em.close();

        System.out.println("Customer saved successfully 🚀");
    }
}