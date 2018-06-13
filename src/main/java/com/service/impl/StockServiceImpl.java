package com.service.impl;

import com.dao.StockDao;
import com.model.Stock;
import com.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class StockServiceImpl implements StockService {
    @Autowired(required = false)

    private StockDao stockDao;


    @Override
    public List<Stock> getAllStocks() {
        return stockDao.getAllStacks();
    }

    @Override
    public Stock getStockById(int id) {
        return stockDao.getStockById(id);
    }

    @Override
    public void deleteStock(int id) {
        stockDao.deleteStock(id);

    }

    @Override
    public void addStock(Stock stock) {
        stockDao.addStock(stock);

    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockDao.updateStock(stock);
    }
}
