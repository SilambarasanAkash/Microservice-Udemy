package com.eazybytes.card.service;

import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.entity.Cards;

import java.util.Optional;

public interface IcardService {

    void createCard(String cardDto);

    boolean updateCard(CardDto cardDto);

    Cards fetchCard(String mobileNumber);

    boolean deleteCard(String mobileNumber);

}
