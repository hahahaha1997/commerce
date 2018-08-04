package com.example.commerce.surface;

import com.example.commerce.entity.BorrowGood;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface BorrowGoodService {

    List<BorrowGood> getAllGoodByBorrowerId(Integer id);

    void deleteborrowGood(Integer id);

    BorrowGood addNewBorrowerGood(BorrowGood borrowGood);

    List<BorrowGood> findall();

    BorrowGood findbygoodid(Integer id);


}
