package com.eazybytes.cards.repository;

import com.eazybytes.cards.entity.CardsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICardsRepository extends JpaRepository<CardsInfo, Long>
{
    CardsInfo findByMobileNumber(String mobileNumber);

    Optional<CardsInfo> findByCardNumber(String cardNumber);
}
