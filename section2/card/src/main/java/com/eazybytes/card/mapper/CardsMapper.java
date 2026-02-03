package com.eazybytes.card.mapper;

import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.entity.Cards;
import lombok.Data;

import javax.smartcardio.Card;

@Data
public class CardsMapper {


    public static Cards mapToCard(Cards cards, CardDto cardDto){
        cards.setCardNumber(cardDto.getCardNumber());
        cards.setCardType(cardDto.getCardType());
        cards.setMobileNumber(cardDto.getMobileNumber());
        cards.setAmountUsed(cardDto.getAmountUsed());
        cards.setAvailableAmount(cardDto.getAvailableAmount());
        cards.setTotalLimit(cardDto.getTotalLimit());
        return cards;

    }

    public static CardDto mapToCardDto(CardDto cardDto,Cards cards){

        cardDto.setCardNumber(cards.getCardNumber());
        cardDto.setCardType(cards.getCardType());
        cardDto.setAmountUsed(cards.getAmountUsed());
        cardDto.setTotalLimit(cards.getTotalLimit());
        cardDto.setMobileNumber(cards.getMobileNumber());
        cardDto.setAvailableAmount(cards.getAvailableAmount());

        return cardDto;

    }

}
