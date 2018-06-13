package com.dao.impl;

import com.dao.StockDao;
import com.model.Stock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(Transactional.TxType.REQUIRED)
public class StockDaoImpl implements StockDao {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Stock> getAllStacks() {
        var resultList = entityManager.createQuery("from Stock as stock ORDER BY stock.name").getResultList();
        return resultList;
    }

    @Override
    public Stock getStockById(int id) {
        return entityManager.find(Stock.class, id);
    }

    @Override
    public void deleteStock(int id) {
        entityManager.remove(getStockById(id));

    }

    @Override
    public void addStock(Stock stock) {
        entityManager.persist(stock);

    }

    @Override
    public Stock updateStock(Stock stock) {
        entityManager.merge(stock);
        return stock;
    }
}
