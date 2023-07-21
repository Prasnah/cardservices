package com.prasanna.cardservices.controller;

import com.prasanna.cardservices.Entity.Customer;
import com.prasanna.cardservices.model.CustomersSummary;
import com.prasanna.cardservices.services.CardProcessService;
import com.prasanna.cardservices.services.CustomerService;
import lombok.CustomLog;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {
    private final CardProcessService cardProcessService;

    @Autowired
    public CardController(@NonNull final CardProcessService cardProcessService) {
        this.cardProcessService = cardProcessService;
    }

    @PostMapping("/process")
    public ResponseEntity<CustomersSummary> processCustomer(@NonNull final List<Customer> customers) {
        return ResponseEntity.ok(this.cardProcessService.processCards(customers));
    }
}
