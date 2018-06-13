package com.dao;

import com.model.Stock;

import java.util.List;

public interface StockDao {

    List<Stock> getAllStacks();
    Stock getStockById(int id);
    void deleteStock(int id);
    void addStock(Stock stock);
    Stock updateStock(Stock stock);
}
