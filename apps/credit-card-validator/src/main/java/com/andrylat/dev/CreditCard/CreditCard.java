package com.andrylat.dev.CreditCard;

import com.andrylat.dev.Enums.CreditCardProvider;

public class CreditCard {
    final String Input;
    final Long InputNumeric;
    public boolean IsValid = false;
    public CreditCardProvider Provider;

    public CreditCard(String _Input) {
        Input = _Input;
        InputNumeric = ParseInput();
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
        return false;
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
            result = Long.valueOf(Input.trim().replace(" ", ""));
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