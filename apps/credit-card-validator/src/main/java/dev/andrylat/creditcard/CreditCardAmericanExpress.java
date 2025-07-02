package dev.andrylat.creditcard;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCardAmericanExpress extends CreditCard {
    public CreditCardAmericanExpress(String _input) {
        super(_input);
        provider = CreditCardProvider.AMERICAN_EXPRESS;
    }

    @Override
    public boolean validCardProvider() {
        int[] inputs = new int[] { 34, 37 };
        int number = (getDigit(0) * 10) + getDigit(1);
        
        for (int input : inputs)
            if (input == number)
                return true;

        return false;
    }
}