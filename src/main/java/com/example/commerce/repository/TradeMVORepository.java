package com.example.commerce.repository;

import com.example.commerce.entity.Trade_MVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TradeMVORepository extends JpaRepository<Trade_MVO,Integer> {

    /**
     * findbybranderid
     * @param id
     * @return List<Trade_MVO>
     */
    @Query(value="select s from Trade_MVO s where s.brander.branderId=?1")
    List<Trade_MVO> findbybranderid(Integer id);
}
