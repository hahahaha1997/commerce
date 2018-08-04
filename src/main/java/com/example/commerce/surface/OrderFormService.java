package com.example.commerce.surface;

import com.example.commerce.entity.OrderForm;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderFormService {

    List<OrderForm> getByNutOrderFormId(Integer id);

    OrderForm addNew(OrderForm orderForm);

}
