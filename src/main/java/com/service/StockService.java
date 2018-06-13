package com.service;

import com.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getStockById(int id);
    void deleteStock(int id);
    void addStock(Stock stock);
    Stock updateStock(Stock stock);
}
