package com.example.commerce.surface;

import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Trade_MVO;

import java.util.List;

public interface TradeMVOService {

    List<Trade_MVO> findbybranderid(Integer id);

    Trade_MVO addNewTrade(Trade_MVO trade_mvo);

}
