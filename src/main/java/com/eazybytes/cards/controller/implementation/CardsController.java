package com.eazybytes.cards.controller.implementation;

import com.eazybytes.cards.constants.BusinessConstants;
import com.eazybytes.cards.controller.interfaces.ICardsController;
import com.eazybytes.cards.entity.CardsInfo;
import com.eazybytes.cards.mapper.interfaces.ICardsMapper;
import com.eazybytes.cards.models.Cards;
import com.eazybytes.cards.models.Response;
import com.eazybytes.cards.service.interfaces.ICardsApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CardsController implements ICardsController
{
    ICardsApplicationService cardsApplicationService;

    ICardsMapper cardsMapper;

    @Override
    public ResponseEntity<Response> createCard(Cards cards)
    {
        CardsInfo cardsInfo = cardsMapper.mapToCardsInfo(cards);
        cardsApplicationService.createCard(cardsInfo);
        Response response = getResponse(BusinessConstants.CREATED_STATUS_CODE,
                BusinessConstants.CREATED_STATUS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private static Response getResponse(String statusCode, String statusMessage)
    {
        Response response = new Response();
        response.setStatusCode(statusCode);
        response.setStatusMessage(statusMessage);
        return response;
    }

    @Override
    public ResponseEntity<Cards> getCard(String mobileNumber)
    {
        CardsInfo cardsInfo = cardsApplicationService.getCard(mobileNumber);
        Cards cards = cardsMapper.mapToCards(cardsInfo);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateCard(Cards cards)
    {
        CardsInfo cardsInfo = cardsMapper.mapToCardsInfo(cards);
        cardsApplicationService.updateCard(cardsInfo);
        Response response = getResponse(BusinessConstants.OK_STATUS_CODE, BusinessConstants.OK_STATUS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteCard(String mobileNumber)
    {
        CardsInfo cardsInfo = cardsApplicationService.getCard(mobileNumber);
        cardsApplicationService.deleteCard(cardsInfo.getCardId());
        Response response = getResponse(BusinessConstants.OK_STATUS_CODE, BusinessConstants.OK_STATUS_MESSAGE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
