package com.eazybytes.cards.service.implementation;

import com.eazybytes.cards.entity.CardsInfo;
import com.eazybytes.cards.exception.EntityAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.interfaces.ICardsMapper;
import com.eazybytes.cards.repository.ICardsRepository;
import com.eazybytes.cards.service.interfaces.ICardsApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardsApplicationService implements ICardsApplicationService
{
    ICardsRepository cardsRepository;

    ICardsMapper cardsMapper;

    @Override
    public void createCard(CardsInfo cardsInfo)
    {
        if (cardsInfo != null)
        {
            if (cardsRepository.findByMobileNumber(cardsInfo.getMobileNumber()) != null)
            {
                throw new EntityAlreadyExistsException("Card with this ID already exists.");
            }
            cardsRepository.save(cardsInfo);
        }
    }

    @Override
    public CardsInfo getCard(String mobileNumber)
    {
        CardsInfo cardsInfo = cardsRepository.findByMobileNumber(mobileNumber);
        if (cardsInfo == null)
        {
            throw new ResourceNotFoundException("Card not found for mobile number: " + mobileNumber);
        }
        return cardsInfo;
    }

    @Transactional
    @Override
    public void deleteCard(Long cardId)
    {
        cardsRepository.deleteById(cardId);
    }

    @Override
    public void updateCard(CardsInfo cardsInfo)
    {
        if (cardsInfo != null)
        {
            Optional<CardsInfo> existingCard = cardsRepository.findByCardNumber(cardsInfo.getCardNumber());

            if (existingCard.isPresent())
            {
                CardsInfo cardToUpdate = cardsMapper.mapToCardsInfo(cardsInfo, existingCard.get());
                cardsRepository.save(cardToUpdate);
            }
            else
            {
                throw new ResourceNotFoundException("Card not found for ID: " + cardsInfo.getCardId());
            }
        }

    }
}
