package com.dao.impl;

import com.dao.TradeDao;
import com.model.Trade;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(Transactional.TxType.REQUIRED)
public class TradeDaoImpl implements TradeDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Trade> getAllTrades() {
        return entityManager.createQuery("from Trade as trade ORDER BY trade.dateTime").getResultList();
    }

    @Override
    public Trade getTradeById(int id) {
        return entityManager.find(Trade.class, id);
    }

    @Override
    public void deleteTrade(int id) {
        entityManager.remove(id);

    }

    @Override
    public void addTrade(Trade trade) {
        entityManager.persist(trade);

    }

    @Override
    public Trade updateTrade(Trade trade) {
        entityManager.merge(trade);
        return trade;
    }
}
