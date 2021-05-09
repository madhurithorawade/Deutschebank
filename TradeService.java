package com.example.trade.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trade.entity.TradeEntity;
import com.example.trade.repository.TradeRepository;

@Service
public class TradeService {
	
	@Autowired
	TradeRepository tradeRepository;

	   public TradeEntity createOrUpdateTrade(TradeEntity entity) throws Exception 
	    {
	        Optional<TradeEntity> tradeEntity = tradeRepository.findById(entity.getTradeId());
	         
	        if(tradeEntity.isPresent()) 
	        {
	            TradeEntity newEntity = tradeEntity.get();
	            newEntity.setBookId(entity.getBookId());
	            newEntity.setCounterPart(entity.getCounterPart());
	            newEntity.setExpired(entity.getExpired());
	            newEntity.setVersion(entity.getVersion());
	            newEntity.setMaturityDate(entity.getMaturityDate());
	            newEntity.setCreatedDate(entity.getCreatedDate());
	            newEntity = tradeRepository.save(newEntity);
	            return newEntity;
	        } else {
	        	if(entity.getCreatedDate().compareTo(entity.getMaturityDate()) < 0 ){
	            entity = tradeRepository.save(entity);
	        	}
	            return entity;
	        }
	    } 
	   
	   public List<TradeEntity> getAllTradeData()
	    {
	        List<TradeEntity> tradeList = tradeRepository.findAll();
	         
	        if(tradeList.size() > 0) {
	            return tradeList;
	        } else {
	            return new ArrayList<TradeEntity>();
	        }
	    }
}
