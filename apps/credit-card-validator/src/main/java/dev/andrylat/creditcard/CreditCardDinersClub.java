package dev.andrylat.creditcard;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCardDinersClub extends CreditCard {
    public CreditCardDinersClub(String _input) {
        super(_input);
        
        provider = CreditCardProvider.DINERS_CLUB;
    }

    @Override
    public boolean validCardProvider() {
        int[] inputs = new int[] { 36, 38 };
        int number = (getDigit(0) * 10) + getDigit(1);
        
        for (int input : inputs)
            if (input == number)
                return true;

        return false;
    }
}