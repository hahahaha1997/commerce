package com.example.commerce.surface;

import com.example.commerce.entity.Pay;

import java.util.List;

public interface PayService {

    Pay findById(Integer id);

    List<Pay> findall();

}
