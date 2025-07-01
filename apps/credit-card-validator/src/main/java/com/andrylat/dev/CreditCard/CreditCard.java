package com.andrylat.dev.CreditCard;

import com.andrylat.dev.Enums.CreditCardProvider;

public class CreditCard {
    final String InputOriginal;
    final Long InputNumeric;
    public boolean IsValid = false;
    public CreditCardProvider Provider;

    public CreditCard(String _Input) {
        InputOriginal = _Input;
        InputNumeric = ParseInput();
    }

    /**
     * TODO: put in utility class, but too lazy right now.
     * Helper function that gets the digit of a number by position from the left.
     * @param digit
     * @return
     */
    final static Integer GetDigit(Long digit, int position) {
        int result = (int)((digit / (1 * (Math.pow(10, Long.toString(digit).length() - 1 - position)))) % 10);
        return result;
    }

    /**
     * Checks if a card has a valid input in the first place.
     * @param card
     * @return boolean
     */
    public final static boolean IsValidInput(CreditCard card) {
        return Long.toString(card.InputNumeric).length() == 16;
    }

    /**
     * Checks if a card is valid based on the last digit, as all credit card are suffix'd by 1 digit via Luhh's algorithm. 
     * @param card
     * @return boolean
     */
    public final static boolean IsValidNumber(CreditCard card) {
        int sum = 0;

        String string = Long.toString(card.InputNumeric);
        // even digits, multiple by 2, add result of digits if 2 digit, and return result
        // odd digits, return result
        // ignore last number as it is the checkDigit
        for (int i = 0; i < string.length() - 1; i++) {
            Integer number = GetDigit(card.InputNumeric, i);

            if(i % 2 == 0) {
                number = number * 2;

                if(number >= 10) {
                    sum += (number / 10) + (number % 10);
                    continue;
                }
            }

            sum += number;
        }
        
        // check digit is the value needed to make the result a multiple of 10
        int checkDigit = 10 - (sum % 10);
        return checkDigit == GetDigit(card.InputNumeric, Long.toString(card.InputNumeric).length() - 1);
    }
    
    /**
     * Check if this card currently belongs to the provider it's associated with.
     * @return boolean
     */
    public boolean CardProvider() {
        return false;
    }

    /**
     * Parses the input locally into a long, and returns the result.
     * @return
     */
    final Long ParseInput() {
        Long result = -1L;

        try {
            result = Long.valueOf(InputOriginal.trim().replace(" ", ""));
        } catch (NumberFormatException err) {
            
        }

        return result;
    }

    /**
     * Updates 'IsValid' for whether or not the card is valid, and returns the result of the action on the property 'IsValid'.
     * @return boolean
     */
    public final boolean Validate() {
        boolean ValidInput = CreditCard.IsValidInput(this);
        boolean ValidProvider = CardProvider();
        boolean ValidNumber = CreditCard.IsValidNumber(this);
        IsValid = ValidInput && ValidProvider && ValidNumber;
        return IsValid;
    }
}