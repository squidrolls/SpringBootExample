package com.elaine.customer;

import com.elaine.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

//    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomer();
    }

    Customer getCustomer(Long id){
        return customerRepo.getCustomer()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }
}
