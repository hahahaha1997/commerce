package com.example.commerce.repository;

import com.example.commerce.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PayRepository extends JpaRepository<Pay,Integer> {
}
