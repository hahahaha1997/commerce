package com.example.commerce.surface;

import com.example.commerce.entity.Customer;
import com.example.commerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements  CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public Customer findbyid(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findall() {
        return customerRepository.findAll();
    }
}
