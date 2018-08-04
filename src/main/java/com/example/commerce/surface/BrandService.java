package com.example.commerce.surface;

import com.example.commerce.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> findAllBrand();

    List<Brand> findByBranderId(Integer id);

    Brand findById(Integer id);

    Brand alterBrand(Brand brand);

    Brand addBrand(Brand brand);

}
