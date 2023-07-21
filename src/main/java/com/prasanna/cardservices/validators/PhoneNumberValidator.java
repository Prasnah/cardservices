package com.prasanna.cardservices.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final String PHONE_NUMBER_REGEX = "\\d{10}"; // Change regex according to your desired format

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null) {
            return true; // Null values are considered valid
        }
         System.out.println("Helllo");
        // You can add more validation logic here if needed, e.g., check for different phone number formats
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }
}
