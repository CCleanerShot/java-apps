package dev.andrylat.creditcard;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCardMastercard extends CreditCard {
    public CreditCardMastercard(String _input) {
        super(_input);
        
        provider = CreditCardProvider.MASTERCARD;
    }

    @Override
    public boolean validCardProvider() {
        int[] inputs = new int[] { 6011, 65 };
        int number = getDigit(0) + getDigit(1);
        
        for (int input : inputs) {
            if (input != number)
                return false;
        }

        return true;
    }
}