package com.eazybytes.card.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "cards")
public class Cards extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private Integer totalLimit;

    @Column(name = "amount_used")
    private Integer amountUsed;

    @Column(name = "available_amount")
    private Integer availableAmount;


}
