package com.prasanna.cardservices.controller;


import com.prasanna.cardservices.Entity.Customer;
import com.prasanna.cardservices.services.CustomerService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(@NonNull CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity createCustomer(@Valid @NonNull @RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/getAllCustomers/{id}")
    public ResponseEntity<Customer> getAllCustomer(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(customerService.customerById(customerId));
    }

    @DeleteMapping("/removeCustomers/{id}")
    public ResponseEntity removeCustomers(@PathVariable("customerId") Long customerId) {
        customerService.removeCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        String errorMessage = "An error occurred: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
