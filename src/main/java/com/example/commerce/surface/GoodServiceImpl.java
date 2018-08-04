package com.example.commerce.surface;

import com.example.commerce.entity.Good;
import com.example.commerce.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodRepository goodRepository;


    @Override
    public List<Good> findByBranderId(Integer id) {
        List<Good> goods = goodRepository.findByBranId(id);
        return goods;
    }

    @Override
    public Good findById(Integer id) {
        return goodRepository.findById(id).get();
    }

    @Override
    public Good alterGood(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public List<Good> findActiveGood(String s) {
        List<Good> goods=goodRepository.findActiceGood(s);
        return goods;
    }

    @Override
    public Good addNewGood(Good good) {
        return goodRepository.save(good);
    }
}
