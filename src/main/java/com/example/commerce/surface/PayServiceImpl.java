package com.example.commerce.surface;

import com.example.commerce.entity.Pay;
import com.example.commerce.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements  PayService {

    @Autowired
    PayRepository payRepository;

    @Override
    public List<Pay> findall() {
        return payRepository.findAll();
    }

    @Override
    public Pay findById(Integer id) {
        return payRepository.findById(id).get();
    }
}
