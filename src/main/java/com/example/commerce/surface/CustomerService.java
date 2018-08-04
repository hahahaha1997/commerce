package com.example.commerce.surface;

import com.example.commerce.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findall();

    Customer findbyid(Integer id);


}
