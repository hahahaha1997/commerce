package com.example.commerce.repository;

import com.example.commerce.entity.NutOrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NutOrderRepository extends JpaRepository<NutOrderForm,Integer> {


    /**
     * getByBorrowId
     * @param id
     * @return List<NutOrderForm>
     */
    @Query(value = "select  s from NutOrderForm s where s.borrowerId.borrowerId=?1 and s.branderId is null" )
    List<NutOrderForm> getByBorrowId(Integer id);

    /**
     * getByBrandId
     * @param id
     * @return List<NutOrderForm>
     */
    @Query(value = "select  m from NutOrderForm m where m.branderId.branderId=?1 and m.customerId is null")
    List<NutOrderForm> getByBrandId(Integer id);



}
