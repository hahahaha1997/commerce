package com.example.commerce.repository;

import com.example.commerce.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Integer> {
}
