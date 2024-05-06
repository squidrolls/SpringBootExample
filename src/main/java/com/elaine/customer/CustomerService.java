package com.elaine.customer;

import com.elaine.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }
}
