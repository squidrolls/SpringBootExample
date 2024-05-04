package com.elaine.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
//@Primary
public class CustomerRepository implements CustomerRepo{

    //TODO: connect to real db
    @Override
    public List<Customer> getCustomer() {
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement read db","todo","email@gmail.com"));
    }
}
