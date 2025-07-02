package dev.andrylat.creditcard;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCardDiscover extends CreditCard {
    public CreditCardDiscover(String _input) {
        super(_input);
        
        provider = CreditCardProvider.DISCOVER;
    }

    @Override
    public boolean validCardProvider() {
        int[] inputs = new int[] { 6011, 65 };
        int number1 = (getDigit(0) * 10) + getDigit(1);
        int number2 = (getDigit(0) * 1000) + (getDigit(1) * 100) + (getDigit(2) * 10) + (getDigit(3));

        for (int input : inputs)
            if (input == number1 || input == number2)
                return true;

        return false;
    }
}