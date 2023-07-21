package com.prasanna.cardservices;

import com.prasanna.cardservices.Entity.Customer;
import com.prasanna.cardservices.controller.CardController;
import com.prasanna.cardservices.controller.CustomerController;
import com.prasanna.cardservices.model.CustomersSummary;
import com.prasanna.cardservices.repository.ICustomerRepository;
import com.prasanna.cardservices.services.CardProcessService;
import com.prasanna.cardservices.services.CustomerService;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class CardServicesApplicationTests {
    private CustomerController customerController;
    private CustomerService customerService;
    @Mock
    private ICustomerRepository iCustomerRepository;
    private CardController cardController;
    private CardProcessService cardProcessService;

    @BeforeEach
    void contextLoads() {
        MockitoAnnotations.initMocks(this);
        this.customerService = new CustomerService(iCustomerRepository);
        this.customerController = new CustomerController(customerService);
        this.cardProcessService = new CardProcessService();
    }

    @Test
    public void checkCustomerById() {
        doReturn(Optional.of(new Customer("Prasanna", "7434343434", 22, 50000.00))).when(iCustomerRepository).findById(1L);
        Assertions.assertEquals("Prasanna", customerService.customerById(1L).getCustomerName());
    }

    @Test
    public void checkApprovalProcessWithCustomers() {
        doReturn(Optional.of(new Customer("Prasanna", "7434343434", 22, 50000.00))).when(iCustomerRepository).findById(1L);
        CustomersSummary customersSummary = cardProcessService.processCards(Arrays.asList(new Customer("Prasanna", "7434343434", 22, 51000.00), (new Customer("Kumar", "7434343434", 22, 52000.00))));
        Assertions.assertEquals(2, customersSummary.getApprovedCustomer().size());
    }


}
