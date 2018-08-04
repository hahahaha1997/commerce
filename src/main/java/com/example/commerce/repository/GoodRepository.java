package com.example.commerce.repository;

import com.example.commerce.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good,Integer> {

    /**
     * findByBranId
     * @param id
     * @return List<Good>
     */
    @Query(value = "select s from Good s where s.branderId.branderId=?1")
    List<Good> findByBranId(Integer id);


    /**
     * findActiveGood
     * @param s
     * @return List<Good>
     */
    @Query(value = "select m from Good m where m.goodStatus=?1")
    List<Good> findActiceGood(String s);


}
