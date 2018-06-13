package com.service.impl;

import com.dao.TradeDao;
import com.model.Trade;
import com.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;
    @Override
    public List<Trade> getAllTrades() {
        return tradeDao.getAllTrades();
    }

    @Override
    public List<Trade> getAllTradesByUser(int id) {
        return tradeDao.getAllTrades()
                .stream()
                .filter(trade->trade.getCustomer().getId()==id)
                .sorted((trade1, trade2) -> (trade1.getDateTime().compareTo(trade2.getDateTime())))
                .collect(toList());
    }

    @Override
    public Trade getTradeById(int id) {
        return tradeDao.getTradeById(id);
    }

    @Override
    public void deleteTrade(int id) {
        tradeDao.deleteTrade(id);

    }

    @Override
    public void addTrade(Trade trade) {
        tradeDao.addTrade(trade);

    }

    @Override
    public Trade updateTrade(Trade trade) {
        return tradeDao.updateTrade(trade);
    }
}
