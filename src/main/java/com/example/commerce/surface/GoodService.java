package com.example.commerce.surface;

import com.example.commerce.entity.Good;

import java.util.List;

public interface GoodService {

    List<Good> findByBranderId(Integer id);

    Good findById(Integer id);

    Good addNewGood(Good good);

    Good alterGood(Good good);

    List<Good>findActiveGood(String s);

}
