package com.example.commerce.repository;

import com.example.commerce.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {


    /**
     * findByBranderId
     * @param id
     * @return List<Band>
     */
    @Query(value = "select  s from Brand s where s.branderId.branderId=?1")
    List<Brand> findByBranderId(Integer id);


}
