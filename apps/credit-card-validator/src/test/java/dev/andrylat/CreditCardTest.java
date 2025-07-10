package dev.andrylat.ccleanershot.creditcard_validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import dev.andrylat.ccleanershot.creditcard_validator.creditcard.CreditCard;
import dev.andrylat.ccleanershot.creditcard_validator.enums.CreditCardProvider;


public class CreditCardTest {

    @ParameterizedTest()
    @ValueSource(strings = { "3457623898234118", "4242 4242 4242 4242", "3818 4829 2716 4729", "3438 2717 4858 1926" })
    void validCards(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(true, card.getErrors().isEmpty(), input);
    }

    @ParameterizedTest()
    @ValueSource(strings = { "3457623898234113", "4242 4242 4242 0001", "3818 4829 2716 4726", "3438 2717 4858 1936" })
    void invalidCards(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(true, card.getErrors().isEmpty());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "2817291823901827", "1827 2843 2019 2892", "2817  2187 2857 4920", "1762 2948 2010 1752" })
    void validLengthWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(true, card.isValidLength());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA2817238118271728sjw", "2817 2834 4781 4912s", "0182 3821 4711 132", "a2918 2847 2716 1627" })
    void validLengthWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(false, card.isValidLength());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "3457623898234113", "3718 4829 2716 4728", "3438 2717 4858 1922", "3729 4728 4716 4786", "3442 4242 4242 4242" })
    void validProviderAmericanExpressWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(CreditCardProvider.AMERICAN_EXPRESS, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA2817238118271728sjw", "3317 2834 4781 4912", "3582 3821 4711 2131", "3600 0000 0000 0000", "3299 9999 9999 9999" })
    void validProviderAmericanExpressWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(CreditCardProvider.AMERICAN_EXPRESS, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "3657623898234113", "3618 4829 2716 4728", "3838 2717 4858 1922", "3829 4728 4716 4786", "3642 4242 4242 4242" })
    void validProviderDinersClubWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(CreditCardProvider.DINERS_CLUB, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA2817238118271728sjw", "3317 2834 4781 4912", "3582 3821 4711 2131", "3100 0000 0000 0000", "3299 9999 9999 9999" })
    void validProviderDinersClubWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(CreditCardProvider.DINERS_CLUB, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "6011623898234113", "6501 1829 2716 4728", "6522 2717 4858 1922", "6011 4728 4716 4786", "6510 4242 4242 4242" })
    void validProviderDiscoverWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(CreditCardProvider.DISCOVER, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA6417238118271728sjw", "3657 2834 4781 4912", "3582 6011 4711 2131", "1100 0000 0000 0000", "2399 9999 9999 9999" })
    void validProviderDiscoverWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(CreditCardProvider.DISCOVER, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "3511623898234113", "3501 1829 2716 4728", "3535 2717 4858 1922", "3500 4728 4716 4786", "3522 4242 4242 4242" })
    void validProviderJCBWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(CreditCardProvider.JCB, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA6417358118271728sjw", "9957 2834 4781 4912", "3182 6011 4711 2131", "1350 0000 0000 0000", "0359 9999 9999 9999" })
    void validProviderJCBWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(CreditCardProvider.JCB, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "5111623898234113", "5201 1829 2716 4728", "5335 2717 4858 1922", "5400 4728 4716 4786", "5522 4242 4242 4242" })
    void validProviderMastercardWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(CreditCardProvider.MASTERCARD, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA6017358118271728sjw", "5957 2834 4781 4912", "5082 6011 4711 2131", "1550 0000 0000 0000", "5609 9999 9999 9999" })
    void validProviderMastercardWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(CreditCardProvider.MASTERCARD, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "4457623898234113", "4118 4829 2716 4728", "4238 2717 4858 1922", "4829 4728 4716 4786", "4242 4242 4242 4242" })
    void validProviderVisaWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(CreditCardProvider.VISA, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA2817238118271728sjw", "2817 2834 4781 4912", "0182 3821 4711 2131", "0000 0000 0000 0000", "9999 9999 9999 9999" })
    void validProviderVisaWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertNotEquals(CreditCardProvider.VISA, card.getCardProvider());
    }

    @ParameterizedTest()
    @ValueSource(strings = { "5457623898234113", "3918 4829 2716 4728", "1238 2717 4858 1922", "5829 4728 4716 4786", "4242 4242 4242 4242" })
    void validNumberWorksForValid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(true, card.isValidNumber());
    }

    @ParameterizedTest()
    @ValueSource(strings = { " 😀abcA2817238118271728sjw", "2817 2834 4781 4912", "0182 3821 4711 2131", "0000 0000 0000 0000", "9999 9999 9999 9999" })
    void validNumberWorksForInvalid(String input) {
        CreditCard card = new CreditCard(input);
        assertEquals(false, card.isValidNumber());
    }
}