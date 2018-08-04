package com.example.commerce.surface;

import com.example.commerce.entity.NutOrderForm;

import java.util.List;

public interface NutOrderService {

    List<NutOrderForm> findByBorrowId(Integer id);

    List<NutOrderForm> findByBrandId(Integer id);

    NutOrderForm getById(Integer id);

    NutOrderForm addNew(NutOrderForm nutOrderForm);

}
