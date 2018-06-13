package com.service.impl;

import com.dao.StockDao;
import com.model.Stock;
import com.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
@CacheConfig(cacheNames = "stocks")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Override
    @Cacheable
    public List<Stock> getAllStocks() {
        return stockDao.getAllStacks();
    }

    @Override
    @Cacheable
    public Stock getStockById(int id) {
        return stockDao.getStockById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteStock(int id) {
        stockDao.deleteStock(id);

    }

    @Override
    @CacheEvict(allEntries = true)
    public void addStock(Stock stock) {
        stockDao.addStock(stock);

    }

    @Override
    @CacheEvict(allEntries = true)
    public Stock updateStock(Stock stock) {
        return stockDao.updateStock(stock);
    }
}