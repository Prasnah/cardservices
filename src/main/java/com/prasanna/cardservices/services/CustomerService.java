package com.prasanna.cardservices.services;

import com.prasanna.cardservices.Entity.Customer;
import com.prasanna.cardservices.repository.ICustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    private final ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    public void createCustomer(Customer customer) {
        try {
            iCustomerRepository.save(customer);
        } catch (Exception ex) {
            log.error("Exception occurred while creating customer" + ex.getMessage());
        }
    }

    public List<Customer> getAllCustomers() {
        return iCustomerRepository.findAll();
    }

    public Customer customerById(Long id) {
        return iCustomerRepository.findById(id).get();
    }

    public void removeCustomerById(Long id) {
        iCustomerRepository.deleteById(id);
    }
}

