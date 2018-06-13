package com.service.impl;

import com.dao.TradeDao;
import com.model.Trade;
import com.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@CacheConfig(cacheNames = "trades")
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;

    @Override
    @Cacheable
    public List<Trade> getAllTrades() {
        return tradeDao.getAllTrades();
    }

    @Override
    @Cacheable
    public List<Trade> getAllTradesByUser(int id) {
        return tradeDao.getAllTrades()
                .stream()
                .filter(trade->trade.getCustomer().getId()==id)
                .sorted((trade1, trade2) -> (trade1.getDateTime().compareTo(trade2.getDateTime())))
                .collect(toList());
    }

    @Override
    @Cacheable
    public Trade getTradeById(int id) {
        return tradeDao.getTradeById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteTrade(int id) {
        tradeDao.deleteTrade(id);

    }

    @Override
    @CacheEvict(allEntries = true)
    public void addTrade(Trade trade) {
        tradeDao.addTrade(trade);

    }

    @Override
    @CacheEvict(allEntries = true)
    public Trade updateTrade(Trade trade) {
        return tradeDao.updateTrade(trade);
    }
}
