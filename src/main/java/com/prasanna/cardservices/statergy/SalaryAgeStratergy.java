package com.prasanna.cardservices.statergy;

import com.prasanna.cardservices.Entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryAgeStratergy implements CardProcessStratergy {
    @Override
    public List<Customer> processCustomer(List<Customer> customerList) {
        return customerList.stream().filter(customer -> customer.getAge() > 20 && customer.getSalary() > 50000).collect(Collectors.toList());
    }
}
