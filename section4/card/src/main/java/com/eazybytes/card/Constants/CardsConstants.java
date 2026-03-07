package com.eazybytes.card.Constants;

import lombok.Data;

@Data
public class CardsConstants {

    private CardsConstants (){

    }


    public static final String CARDTYPE ="DEBIT_CARD";
    public static final String STATUS_201 ="201";
    public static final String MSG_201 ="Card created successfully";
    public static final String STATUS_200 ="200";
    public static final String MSG_200 ="Request proccessed successfully";
    public static final String STATUS_417 ="417";
    public static final String MSG_417_UPDATE ="Update operation failed. Please try again or contact Dev team";
    public static final String MSG_417_DELETE ="Delete operation failed. Please try again or contact Dev team";

}
