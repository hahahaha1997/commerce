package com.example.commerce.surface;

import com.example.commerce.entity.ShippingAddress;
import com.example.commerce.repository.AddressShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressServiceImpl implements  ShippingAddressService{

    @Autowired
    AddressShippingRepository addressShippingRepository;

    @Override
    public ShippingAddress findbyid(Integer id) {
        return addressShippingRepository.findById(id).get();
    }
}
