package com.eazybytes.card.service;

import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.entity.Cards;
import com.eazybytes.card.exception.AlreadyExistExceptionHandler;
import com.eazybytes.card.exception.GlobalExceptionHandler;
import com.eazybytes.card.exception.ResourceNotFoundException;
import com.eazybytes.card.mapper.CardsMapper;
import com.eazybytes.card.repo.CardRepo;
import com.eazybytes.card.utils.CardsUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService implements IcardService{

    CardRepo cardRepo;

    @Override
    public void createCard(String mobileNumber){

        java.util.Optional<Cards> isAlreadyExist =cardRepo.findByMobileNumber(mobileNumber);

        if(isAlreadyExist.isPresent()){
            throw new AlreadyExistExceptionHandler("Your Shared Mobile Number"+mobileNumber+" is Already Exist");
        }
        com.eazybytes.card.entity.Cards cards = createNewCard(new Cards(),mobileNumber);
        cardRepo.save(cards);

    }


    public Cards createNewCard(Cards cards,String mobileNumber){

        // Example for a Visa card (BIN prefix 4, length 16)
        // Example for a Mastercard (BIN prefix 51-55, length 16)
        cards.setCardNumber(CardsUtils.generateLuhnValidCardNumber("4",16));
        cards.setCardType("Visa Card");
        cards.setMobileNumber(mobileNumber);
        cards.setAvailableAmount(0);
        cards.setTotalLimit(50000);
        cards.setAmountUsed(0);

        return  cards;
    }

    @Override
    public boolean updateCard(CardDto cardDto) {

        java.util.Optional<Cards>cards =cardRepo.findByCardNumber(cardDto.getCardNumber());
        if(cards.isEmpty()){
            throw new ResourceNotFoundException("The Given Card Number "+cardDto.getCardNumber()+" is Invalid");
        }
        CardsMapper.mapToCard(cards.get(),cardDto);
        cardRepo.save(cards.get());
        return true;
    }

    @Override
    public Cards fetchCard(String mobileNumber) {
        Cards cards= cardRepo.findByMobileNumber(mobileNumber).orElseThrow(()->
            new ResourceNotFoundException("Your Given Mobilenumber "+mobileNumber+" is invalid so kindly check ")
        );

        return cards;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards =cardRepo.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("The Given MobileNumber "+mobileNumber+" Doesn't Exist")
        );
        cardRepo.deleteById(cards.getCardId());
        return true;
    }


}
