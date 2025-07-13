package com.eazybytes.cards.service.interfaces;

import com.eazybytes.cards.entity.CardsInfo;

public interface ICardsApplicationService
{
    void createCard(CardsInfo cardsInfo);

    CardsInfo getCard(String mobileNumber);

    void deleteCard(Long cardId);

    void updateCard(CardsInfo cardsInfo);
}
