package com.service;

import com.model.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TradeService {
    List<Trade> getAllTrades();
    List<Trade> getAllTradesByUser(int id);
    Trade getTradeById(int id);
    void deleteTrade(int id);
    void addTrade(Trade trade);
    Trade updateTrade(Trade trade);
}
