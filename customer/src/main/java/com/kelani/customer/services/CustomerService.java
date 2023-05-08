package com.kelani.customer.services;

import com.kelani.customer.models.Customer;
import com.kelani.customer.models.CustomerRegistrationRequest;
import com.kelani.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email is valid or not
        //todo: check if email is already taken or not
        customerRepository.save(customer);
    }
}
