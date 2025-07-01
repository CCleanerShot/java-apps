package com.andrylat.dev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.andrylat.dev.CreditCard.CreditCard;


public class CreditCardValidatorTest {

    @Test
    void creditCardValidatorValidInputWorks() {
        String[] validInputs = new String[] {"2817291823901827", "1827 2843 2019 2892", "2817  2187 2857 4920", "1762 2948 2010 1752"};
        String[] invalidInputs = new String[] {"2817238118271728sjw", "2817 2834 4781 4912s", "0182 3821 4711 132", "a2918 2847 2716 1627"};
        
        for (String input : validInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(CreditCard.IsValidInput(card), true);
        }

        for (String input : invalidInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(CreditCard.IsValidInput(card), false);
        }
    }

    // @Test
    // void creditCardValidatorValidProviderWorks() {
    //     CreditCardValidator validator = new CreditCardValidator();
    //     assertEquals(validator.CardValid(1), false, "CardValid(1) should equal false");
    // }

    @Test
    void creditCardValidatorValidNumberWorks() {
        String[] validInputs = new String[] {"5457623898234113", "3918 4829 2716 4728", "1238 2717 4858 1922", "5829 4728 4716 4786", "4242 4242 4242 4242"};
        String[] invalidInputs = new String[] {"2817238118271728sjw", "2817 2834 4781 4912", "0182 3821 4711 2131", "0000 0000 0000 0000", "9999 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(CreditCard.IsValidNumber(card), true);
        }

        for (String input : invalidInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(CreditCard.IsValidNumber(card), false);
        }
    }
}