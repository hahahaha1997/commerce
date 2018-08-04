package com.example.commerce.surface;

import com.example.commerce.entity.Trade_BVO;
import com.example.commerce.repository.TradeBVORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeBVOServiceImpl implements  TradeBVOService{

    @Autowired
    TradeBVORepository tradeBVORepository;

    @Override
    public Trade_BVO addNewTrade(Trade_BVO trade_bvo) {
        return tradeBVORepository.save(trade_bvo);
    }

    @Override
    public List<Trade_BVO> findbyborroweridandstatus(Integer id,String s) {
        return tradeBVORepository.findbyborroweridandstatus(id,s);
    }
}
