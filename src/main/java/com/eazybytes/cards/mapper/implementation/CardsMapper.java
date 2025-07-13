package com.eazybytes.cards.mapper.implementation;

import com.eazybytes.cards.entity.CardsInfo;
import com.eazybytes.cards.mapper.interfaces.ICardsMapper;
import com.eazybytes.cards.models.Cards;
import org.springframework.stereotype.Component;

@Component
public class CardsMapper implements ICardsMapper
{
    @Override
    public CardsInfo mapToCardsInfo(Cards cards)
    {
        CardsInfo cardsInfo = null;
        if (cards != null)
        {
            cardsInfo = new CardsInfo();
            cardsInfo.setMobileNumber(cards.getMobileNumber());
            cardsInfo.setCardNumber(cards.getCardNumber());
            cardsInfo.setCardType(cards.getCardType());
            cardsInfo.setTotalLimit(cards.getTotalLimit());
            cardsInfo.setAmountUsed(cards.getAmountUsed());
            cardsInfo.setAvailableAmount(cards.getAvailableAmount());
        }
        return cardsInfo;
    }

    @Override
    public Cards mapToCards(CardsInfo cardsInfo)
    {
        Cards cards = null;
        if (cardsInfo != null)
        {
            cards = new Cards();
            cards.setMobileNumber(cardsInfo.getMobileNumber());
            cards.setCardNumber(cardsInfo.getCardNumber());
            cards.setCardType(cardsInfo.getCardType());
            cards.setTotalLimit(cardsInfo.getTotalLimit());
            cards.setAmountUsed(cardsInfo.getAmountUsed());
            cards.setAvailableAmount(cardsInfo.getAvailableAmount());
            cards.setCreatedAt(cardsInfo.getCreatedAt());
            cards.setCreatedBy(cardsInfo.getCreatedBy());
            cards.setUpdatedAt(cardsInfo.getUpdatedAt());
            cards.setUpdatedBy(cardsInfo.getUpdatedBy());
        }
        return cards;
    }

    @Override
    public CardsInfo mapToCardsInfo(CardsInfo cardsInfo, CardsInfo existingCard)
    {
        existingCard.setMobileNumber(cardsInfo.getMobileNumber());
        existingCard.setCardNumber(cardsInfo.getCardNumber());
        existingCard.setCardType(cardsInfo.getCardType());
        existingCard.setTotalLimit(cardsInfo.getTotalLimit());
        existingCard.setAmountUsed(cardsInfo.getAmountUsed());
        existingCard.setAvailableAmount(cardsInfo.getAvailableAmount());
        return existingCard;
    }

}
