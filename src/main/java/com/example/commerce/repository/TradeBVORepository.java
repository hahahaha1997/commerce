package com.example.commerce.repository;

import com.example.commerce.entity.Trade_BVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TradeBVORepository extends JpaRepository<Trade_BVO,Integer> {

    /**
     * findbyborroweridandstatus
     * @param id
     * @param s
     * @return List<Trade_BVO>
     */
    @Query(value = "select  s from Trade_BVO  s where s.borrower.borrowerId=?1 and s.tradeType=?2")
    List<Trade_BVO> findbyborroweridandstatus(Integer id,String s);

}
