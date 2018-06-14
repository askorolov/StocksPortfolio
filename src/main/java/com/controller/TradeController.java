package com.controller;

import com.model.Trade;
import com.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping("/trades")
    public ResponseEntity<List<Trade>> getAllTrades(@RequestParam(required = false) Integer id) {
        var allTrades = id == null ? tradeService.getAllTrades() : tradeService.getAllTradesByUser(id);
        return new ResponseEntity<>(allTrades, HttpStatus.OK);
    }

    @GetMapping("trades/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable("id") Integer id) {
        var trade = tradeService.getTradeById(id);
        return new ResponseEntity<>(trade, HttpStatus.OK);
    }

    @PostMapping("trade")
    public ResponseEntity<List<Trade>> addTrade(@RequestBody Trade trade){
        tradeService.addTrade(trade);
        return new ResponseEntity<>(tradeService.getAllTrades(), HttpStatus.OK);
    }

    @PutMapping("trade")
    public ResponseEntity<List<Trade>> updateTrade(@RequestBody Trade trade){
        tradeService.updateTrade(trade);
        return new ResponseEntity<>(tradeService.getAllTrades(), HttpStatus.OK);
    }

    @DeleteMapping("trades/{id]")
    public ResponseEntity<List<Trade>> deleteTrade(@PathVariable ("id") Integer id){
        tradeService.deleteTrade(id);
        return new ResponseEntity<>(tradeService.getAllTrades(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("trades_by_user/{id}")
    public ResponseEntity<List<Trade>>getTradesByUser(@PathVariable ("id") int id){
        var allTradesByUser = tradeService.getAllTradesByUser(id);
        return new ResponseEntity<>(allTradesByUser, HttpStatus.OK);

    }
}