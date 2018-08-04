package com.example.commerce.surface;

import com.example.commerce.entity.OrderForm;
import com.example.commerce.repository.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormServiceImpl implements  OrderFormService{

    @Autowired
    OrderFormRepository orderFormRepository;

    @Override
    public OrderForm addNew(OrderForm orderForm) {
        return orderFormRepository.save(orderForm);
    }

    @Override
    public List<OrderForm> getByNutOrderFormId(Integer id) {
        return orderFormRepository.getByNutOrderFormId(id);
    }
}
