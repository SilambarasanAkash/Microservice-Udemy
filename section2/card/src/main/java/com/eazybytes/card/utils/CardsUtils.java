package com.eazybytes.card.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;


@Data
public class CardsUtils {


    private CardsUtils(){

    }

    /**
     * Generates a mathematically valid (Luhn algorithm) card number for testing.
     * @param binPrefix The Bank Identification Number prefix (e.g., "4" for Visa, "51" for Mastercard).
     * @param length The total length of the card number (e.g., 16 for most cards).
     * @return A Luhn valid card number string.
     */
    public static String generateLuhnValidCardNumber(String binPrefix, int length) {
        StringBuilder cardNumberBuilder = new StringBuilder(binPrefix);
        Random random = new Random();

        // Generate random digits to fill the card number (minus the check digit)
        while (cardNumberBuilder.length() < length - 1) {
            cardNumberBuilder.append(random.nextInt(10));
        }

        // Calculate and append the Luhn check digit
        String partialCardNumber = cardNumberBuilder.toString();
        int checkDigit = calculateLuhnCheckDigit(partialCardNumber);
        cardNumberBuilder.append(checkDigit);

        return cardNumberBuilder.toString();
    }

    /**
     * Calculates the Luhn check digit for a given partial card number.
     * @param partialCardNumber The card number without the last (check) digit.
     * @return The calculated check digit.
     */
    private static int calculateLuhnCheckDigit(String partialCardNumber) {
        int sum = 0;
        boolean alternate = true;
        // Iterate from right to left (excluding the implied check digit position)
        for (int i = partialCardNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(partialCardNumber.substring(i, i + 1));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        // The check digit is the amount needed to make the sum a multiple of 10
        return (10 - (sum % 10)) % 10;
    }


}
