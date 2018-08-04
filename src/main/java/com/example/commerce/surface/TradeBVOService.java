package com.example.commerce.surface;

import com.example.commerce.entity.Trade_BVO;

import java.util.List;

public interface TradeBVOService  {

    List<Trade_BVO> findbyborroweridandstatus(Integer id,String s);

    Trade_BVO addNewTrade(Trade_BVO trade_bvo);

}
