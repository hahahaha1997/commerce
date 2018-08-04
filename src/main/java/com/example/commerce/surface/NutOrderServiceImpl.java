package com.example.commerce.surface;

import com.example.commerce.entity.NutOrderForm;
import com.example.commerce.repository.NutOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutOrderServiceImpl implements NutOrderService{

    @Autowired
    NutOrderRepository nutOrderRepository;

    @Override
    public List<NutOrderForm> findByBrandId(Integer id) {
        return nutOrderRepository.getByBrandId(id);
    }

    @Override
    public NutOrderForm addNew(NutOrderForm nutOrderForm) {
        return nutOrderRepository.save(nutOrderForm);
    }

    @Override
    public NutOrderForm getById(Integer id) {
        return nutOrderRepository.findById(id).get();
    }

    @Override
    public List<NutOrderForm> findByBorrowId(Integer id) {
        return nutOrderRepository.getByBorrowId(id);
    }
}
