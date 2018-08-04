package com.example.commerce.surface;

import com.example.commerce.entity.Brand;
import com.example.commerce.repository.BrandRepository;
import com.example.commerce.repository.BranderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements  BrandService{

    @Autowired
    public BrandRepository brandRepository;

    @Override
    public List<Brand> findByBranderId(Integer id) {
        return brandRepository.findByBranderId(id);
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand alterBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> findAllBrand() {
        return brandRepository.findAll();
    }
}
