package com.example.commerce.repository;

import com.example.commerce.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressShippingRepository extends JpaRepository<ShippingAddress,Integer> {
}
