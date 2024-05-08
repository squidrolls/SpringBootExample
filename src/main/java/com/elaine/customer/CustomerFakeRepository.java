package com.elaine.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake")
@Repository
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L, "James Bond","password1234", "email@gmail.com"),
                new Customer(2L, "Jamila Ahem","123password","email@gmail.com")
        );
    }
}
