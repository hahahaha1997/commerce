package com.example.commerce.surface;

import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Trade_MVO;
import com.example.commerce.repository.TradeMVORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeMVOServiceImpl implements  TradeMVOService {

    @Autowired
    TradeMVORepository tradeMVORepository;

    @Override
    public Trade_MVO addNewTrade(Trade_MVO trade_mvo) {
        return tradeMVORepository.save(trade_mvo);
    }

    @Override
    public List<Trade_MVO> findbybranderid(Integer id) {
        return tradeMVORepository.findbybranderid(id);
    }
}
