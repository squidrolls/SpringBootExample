package com.elaine.customer;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepo {
    List<Customer> getCustomer();
}
