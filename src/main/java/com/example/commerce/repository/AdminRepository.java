package com.example.commerce.repository;

import com.example.commerce.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {


    /**
     * findByAdminName
     * @param name
     * @return List<Admin>
     */
    List<Admin> findByAdminName(String name);



}
