package dev.andrylat.creditcard;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCardVisa extends CreditCard {
    public CreditCardVisa(String _input) {
        super(_input);

        provider = CreditCardProvider.VISA;
    }

    @Override
    public boolean validCardProvider() {
        return getDigit(0) == 4;
    }
}