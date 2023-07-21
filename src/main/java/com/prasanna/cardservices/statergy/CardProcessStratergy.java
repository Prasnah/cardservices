package com.prasanna.cardservices.statergy;

import com.prasanna.cardservices.Entity.Customer;

import java.util.List;

public interface CardProcessStratergy {
    List<Customer> processCustomer(List<Customer> customerList);

}
