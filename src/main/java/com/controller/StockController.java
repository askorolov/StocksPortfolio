package com.controller;

import com.model.Stock;
import com.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        var stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Integer id){
        var stockById = stockService.getStockById(id);
        return new ResponseEntity<>(stockById, HttpStatus.OK);

    }

    @PostMapping("stock")
    public ResponseEntity<List<Stock>> addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.CREATED);
    }

    @PutMapping("stock")
    public ResponseEntity<List<Stock>> updateStock(@RequestBody Stock stock){
        stockService.updateStock(stock);
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

    @DeleteMapping("stocks/{id}")
    public ResponseEntity<List<Stock>> deleteStock(@PathVariable ("id") Integer id){

        stockService.deleteStock(id);
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.NO_CONTENT);
    }
}
