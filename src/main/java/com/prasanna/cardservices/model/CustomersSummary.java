package com.prasanna.cardservices.model;

import com.prasanna.cardservices.Entity.Customer;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CustomersSummary {
    List<Customer> approvedCustomer;
    List<Customer> rejectedCustomer;
}
