package com.prasanna.cardservices.services;

import com.prasanna.cardservices.Entity.ApplicationStatus;
import com.prasanna.cardservices.Entity.Customer;
import com.prasanna.cardservices.model.CustomersSummary;
import com.prasanna.cardservices.statergy.CardProcessStratergy;
import com.prasanna.cardservices.statergy.SalaryAgeStratergy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CardProcessService {
    CardProcessStratergy cardProcessStratergy = new SalaryAgeStratergy();

    public CustomersSummary processCards(List<Customer> customers) {
        customers.forEach(approvedCustomer -> approvedCustomer.setApplicationStatus(ApplicationStatus.UNDER_REVIEW));
        List<Customer> approvedCustomers = cardProcessStratergy.processCustomer(customers);
        approvedCustomers.forEach(approvedCustomer -> approvedCustomer.setApplicationStatus(ApplicationStatus.APPROVED));
        List<Customer> rejectedCustomers = new ArrayList<>(customers);
        rejectedCustomers.removeAll(approvedCustomers);
        rejectedCustomers.forEach(approvedCustomer -> approvedCustomer.setApplicationStatus(ApplicationStatus.REJECTED));
        return CustomersSummary.builder().approvedCustomer(approvedCustomers).rejectedCustomer(rejectedCustomers).build();
    }
}
