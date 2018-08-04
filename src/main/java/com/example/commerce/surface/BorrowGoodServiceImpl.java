package com.example.commerce.surface;

import com.example.commerce.entity.BorrowGood;
import com.example.commerce.entity.Borrower;
import com.example.commerce.repository.BorrowGoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowGoodServiceImpl implements  BorrowGoodService {

    @Autowired
    BorrowGoodRepository goodRepository;

    @Override
    public void deleteborrowGood(Integer id) {
        BorrowGood  borrowGood = goodRepository.findById(id).get();
        if(borrowGood.getBorrowGoodStatus().equals("已下架")||borrowGood.getBorrowGoodStatus().equals("未上架")){
            borrowGood.setBorrowGoodStatus("已上架");
        }
        else{
            borrowGood.setBorrowGoodStatus("已下架");
        }
        goodRepository.save(borrowGood);
    }

    @Override
    public List<BorrowGood> findall() {
        return goodRepository.findAll();
    }

    @Override
    public BorrowGood addNewBorrowerGood(BorrowGood borrowGood) {
        return goodRepository.save(borrowGood);
    }

    @Override
    public BorrowGood findbygoodid(Integer id) {
        return goodRepository.findbygoodid(id);
    }

    @Override
    public List<BorrowGood> getAllGoodByBorrowerId(Integer id) {
        return goodRepository.findByBorrowerId(id);
    }
}
