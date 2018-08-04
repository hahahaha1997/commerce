package com.example.commerce.repository;

import com.example.commerce.entity.OrderForm;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderFormRepository extends JpaRepository<OrderForm,Integer> {

    /**
     * getByNutOrderForm
     * @param id
     * @return List<OrderForm>
     */
    @Query(value = "select s from OrderForm s where s.nutOrderFormId.nutOrderFormId=?1")
    List<OrderForm> getByNutOrderFormId(Integer id);

}
