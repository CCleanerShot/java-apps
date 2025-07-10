package dev.andrylat.ccleanershot.creditcard_validator.creditcard;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import dev.andrylat.ccleanershot.creditcard_validator.enums.CreditCardProvider;

public class CreditCard {
    private static final int LENGTH_OF_CARD = 16;

    private final String input; // must be stored as string as leading 0s are allowed https://en.wikipedia.org/wiki/Payment_card_number
    private final String inputOriginal;

    protected ArrayList<String> errors = new ArrayList();
    protected boolean isValid = true;
    protected CreditCardProvider provider = CreditCardProvider.UNKNOWN;

    /**
     * On creation, the input will be trimmed of whitespace, and will return -1 if the input contained any invalid characters (like letters).
     */
    public CreditCard(String input) {
        this.inputOriginal = input;
    
        Pattern pattern = Pattern.compile("[^0-9\\s]", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        
        if(matcher.find()) {
            this.input = input;
            this.isValid = false;
            this.errors.add("The input should only contain digits.");
        } else {
            this.input = input.codePoints()
                .filter(Character::isDigit)
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.joining());
        }
        
        if(!isValidLength()) {
            this.isValid = false;
            this.errors.add("The input should have exactly 16 digits.");
        }

        if(!isValidNumber()) {
            this.isValid = false;
            this.errors.add("The input is an invalid card number.");
        }

        if(isProviderAmericanExpress())
            this.provider = CreditCardProvider.AMERICAN_EXPRESS;
        else if (isProviderDinersClub())
            this.provider = CreditCardProvider.DINERS_CLUB;
        else if(isProviderDiscover())
            this.provider = CreditCardProvider.DISCOVER;
        else if(isProviderJCB())
            this.provider = CreditCardProvider.JCB;
        else if(isProviderMasterCard())
            this.provider = CreditCardProvider.MASTERCARD;
        else if(isProviderVisa())
            this.provider = CreditCardProvider.VISA;

        // considered checking all for min length first, and letting providers being easy
        // to set but considering the real parameters, card providers need 16 digits, so
        // even if the first numbers match, if the lengths don't then this should emit
        // errors anyways, preventing someone from guessing a private provider
        if(this.provider == CreditCardProvider.UNKNOWN) {
            this.isValid = false;
            this.errors.add("The input belongs to an unknown card provider.");
        }
    }

    public final CreditCardProvider getCardProvider() {
        return provider;
    }

    Integer getDigit(int position) {
        int result = Character.getNumericValue(input.charAt(position));
        return result;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }
    
    final boolean isProviderAmericanExpress() {
        int[] matches = new int[] { 34, 37 };
        int number = (getDigit(0) * 10) + getDigit(1);
        
        for (int match : matches)
            if (match == number)
                return true;

        return false;
    }

    final boolean isProviderDinersClub() {
        int[] matches = new int[] { 36, 38 };
        int number = (getDigit(0) * 10) + getDigit(1);
        
        for (int match : matches)
            if (match == number)
                return true;

        return false;
    }

    final boolean isProviderDiscover() {
        int[] matches = new int[] { 6011, 65 };
        int number1 = (getDigit(0) * 10) + getDigit(1);
        int number2 = (getDigit(0) * 1000) + (getDigit(1) * 100) + (getDigit(2) * 10) + (getDigit(3));

        for (int match : matches)
            if (match == number1 || match == number2)
                return true;

        return false;
    }

    final boolean isProviderJCB() {
        int[] matches = new int[] { 35 };
        int number = (getDigit(0) * 10) + getDigit(1);

        for (int match : matches)
            if (match == number)
                return true;

        return false;
    }

    final boolean isProviderMasterCard() {
        int[] matches = new int[] { 51, 52, 53, 54, 55 };
        int number = (getDigit(0) * 10) + getDigit(1);
        
        for (int match : matches)
            if (match == number)
                return true;

        return false;
    }

    final boolean isProviderVisa() {
        return getDigit(0) == 4;
    }

    public final boolean isValidLength() {
        return input.length() == LENGTH_OF_CARD;
    }

    /**
     * Checks if a card is valid based on the last digit, as all credit card are suffix'd by 1 digit via Luhh's algorithm. 
     * @param card
     * @return boolean
     */
    public final boolean isValidNumber() {
        int sum = 0;

        // even digits, multiple by 2, add result of digits if 2 digit, and return result
        // odd digits, return result
        // ignore last number as it is the checkDigit
        for (int i = 0; i < input.length() - 1; i++) {
            Integer number = getDigit(i);

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
        return checkDigit == getDigit(input.length() - 1);
    }
}