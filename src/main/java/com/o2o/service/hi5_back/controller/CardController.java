package com.o2o.service.hi5_back.controller;
/*
 * Created by 이동기 on 2022-03-21
 */

import com.o2o.service.hi5_back.DTO.CardDTO;
import com.o2o.service.hi5_back.model.Card;
import com.o2o.service.hi5_back.repository.CardRepository;
import com.o2o.service.hi5_back.util.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class CardController implements Serializable {
    private final Logger logger = LoggerFactory.getLogger(CardController.class);
    private final CardRepository cardRepository;
    private final ObjectConverter objectConverter;

    @Autowired
    public CardController(CardRepository cardRepository, ObjectConverter objectConverter) {
        this.cardRepository = cardRepository;
        this.objectConverter = objectConverter;
    }

    @GetMapping(value = "/card/{userId}")
    public List<CardDTO> getCard(@PathVariable String userId){
        logger.info("request card >>");
        logger.info("userId:{}",userId);
        List<Card> cardList = cardRepository.findCardByUserIdOrderByShowOrder(userId);
        List<CardDTO> cardDTOList = objectConverter.convertCardListToDTOList(cardList);
        return cardDTOList;
    }

}