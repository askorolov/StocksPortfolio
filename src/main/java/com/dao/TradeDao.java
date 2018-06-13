package com.dao;

import com.model.Trade;

import java.util.List;

public interface TradeDao {
    List<Trade> getAllTrades();
    Trade getTradeById(int id);
    void deleteTrade(int id);
    void addTrade(Trade trade);
    Trade updateTrade(Trade trade);
}
