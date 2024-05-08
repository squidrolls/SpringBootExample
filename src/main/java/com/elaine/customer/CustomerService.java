package com.elaine.customer;

import com.elaine.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }

    List<Customer> getCustomers(){
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                    LOGGER.error("error in getting Customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
