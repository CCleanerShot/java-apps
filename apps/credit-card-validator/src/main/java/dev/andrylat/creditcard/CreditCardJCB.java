package dev.andrylat.creditcard;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCardJCB extends CreditCard {
    public CreditCardJCB(String _input) {
        super(_input);
        
        provider = CreditCardProvider.JCB;
    }

    @Override
    public boolean validCardProvider() {
        int[] inputs = new int[] { 35 };
        int number = (getDigit(0) * 10) + getDigit(1);

        for (int input : inputs)
            if (input == number)
                return true;

        return false;
    }
}