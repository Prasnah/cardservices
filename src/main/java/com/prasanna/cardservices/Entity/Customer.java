package com.prasanna.cardservices.Entity;

import com.prasanna.cardservices.validators.ValidPhoneNumber;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;


@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @NonNull
    private String customerName;
    @NonNull
    @ValidPhoneNumber
    private String customerPhoneNumber;
    private String address;
    @NonNull
    @Max(130)
    private int age;
    @NonNull
    private Double salary;
    @Setter
    private ApplicationStatus applicationStatus;
}
