package com.eazybytes.cards.mapper.interfaces;

import com.eazybytes.cards.entity.CardsInfo;
import com.eazybytes.cards.models.Cards;

import java.util.Optional;

public interface ICardsMapper
{
    CardsInfo mapToCardsInfo(Cards cards);

    Cards mapToCards(CardsInfo cardsInfo);

    CardsInfo mapToCardsInfo(CardsInfo cardsInfo, CardsInfo existingCard);
}
