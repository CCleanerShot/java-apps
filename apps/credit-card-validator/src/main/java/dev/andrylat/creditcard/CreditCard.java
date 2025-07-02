package dev.andrylat.creditcard;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import dev.andrylat.enums.CreditCardProvider;

public class CreditCard {
    private static final int LENGTH_OF_CARD = 16;

    private final String input; // must be stored as string as leading 0s are allowed https://en.wikipedia.org/wiki/Payment_card_number
    private final String inputOriginal;

    protected ArrayList<String> errors = new ArrayList();
    protected boolean isValid = false;
    protected CreditCardProvider provider;

    /**
     * On creation, the input will be trimmed of whitespace, and will return -1 if the input contained any invalid characters (like letters).
     */
    public CreditCard(String input) {
        this.inputOriginal = input;
    
        Pattern pattern = Pattern.compile("[^0-9\\s]");
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()) {
            System.out.println(MessageFormat.format("true {0} {1}", inputOriginal, input));
            this.errors.add("The input should only contain digits.");
            this.input = input;
        } else {
            this.input = input.codePoints()
                .filter(Character::isDigit)
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.joining());
        }

        System.out.println(MessageFormat.format("{0} {1}", inputOriginal, input));
    }

    Integer getDigit(int position) {
        int result = inputOriginal.charAt(position);
        return result;
    }

    public static boolean isValidInput(CreditCard card) {
        return card.inputOriginal.length() == LENGTH_OF_CARD;
    }

    /**
     * Checks if a card is valid based on the last digit, as all credit card are suffix'd by 1 digit via Luhh's algorithm. 
     * @param card
     * @return boolean
     */
    public static boolean isValidNumber(CreditCard card) {
        int sum = 0;

        String string = card.inputOriginal;
        // even digits, multiple by 2, add result of digits if 2 digit, and return result
        // odd digits, return result
        // ignore last number as it is the checkDigit
        for (int i = 0; i < string.length() - 1; i++) {
            Integer number = card.getDigit(i);

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
        return checkDigit == card.getDigit(card.inputOriginal.length() - 1);
    }
    
    /**
     * Check if this card currently belongs to the provider it's associated with.
     * @return boolean
     */
    public boolean validCardProvider() {
        return false;
    }

    public boolean validate() {
        boolean ValidInput = CreditCard.isValidInput(this);
        boolean ValidProvider = validCardProvider();
        boolean ValidNumber = CreditCard.isValidNumber(this);
        isValid = ValidInput && ValidProvider && ValidNumber;
        return isValid;
    }
}