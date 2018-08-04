package com.example.commerce.repository;

import com.example.commerce.entity.BorrowGood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BorrowGoodRepository extends JpaRepository<BorrowGood,Integer> {


    /**
     * findByBorrowerId
     * @param id
     * @return List<BorrowGood>
     */
    @Query(value = "select s from BorrowGood s where s.borrowerId.borrowerId=?1")
    public List<BorrowGood> findByBorrowerId(Integer id);


    /**
     * findbygoodid
     * @param id
     * @return borrowGood
     */
    @Query(value = "select  s from BorrowGood  s where s.goodId.goodId=?1")
    public  BorrowGood findbygoodid(Integer id);


}
