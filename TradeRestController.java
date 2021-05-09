package com.example.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trade.entity.TradeEntity;
import com.example.trade.service.TradeService;

@RestController
@RequestMapping("/tradings")
public class TradeRestController {
	
	@Autowired
	TradeService tradeService;

	@PostMapping
	public ResponseEntity<TradeEntity> createOrUpdateTrade(@RequestBody TradeEntity tradeEntity)
			throws Exception {
		TradeEntity updated = tradeService.createOrUpdateTrade(tradeEntity);
		return new ResponseEntity<TradeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<TradeEntity>> getAllTradeData() {
        List<TradeEntity> list = tradeService.getAllTradeData();
 
        return new ResponseEntity<List<TradeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
