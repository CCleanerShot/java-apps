package dev.andrylat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import dev.andrylat.creditcard.CreditCard;
import dev.andrylat.creditcard.CreditCardAmericanExpress;
import dev.andrylat.creditcard.CreditCardDinersClub;
import dev.andrylat.creditcard.CreditCardDiscover;
import dev.andrylat.creditcard.CreditCardJCB;
import dev.andrylat.creditcard.CreditCardMastercard;
import dev.andrylat.creditcard.CreditCardVisa;


public class CreditCardTest {

    @Test
    void creditCardValidInputWorks() {
        String[] validInputs = new String[] {"2817291823901827", "1827 2843 2019 2892", "2817  2187 2857 4920", "1762 2948 2010 1752"};
        String[] invalidInputs = new String[] {" 😀abcA2817238118271728sjw", "2817 2834 4781 4912s", "0182 3821 4711 132", "a2918 2847 2716 1627"};
        
        for (String input : validInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(true, CreditCard.isValidInput(card));
        }

        for (String input : invalidInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(false, CreditCard.isValidInput(card));
        }
    }

    @Test
    void creditCardValidProviderAmericanExpressWorks() {
        String[] validInputs = new String[] {"3457623898234113", "3718 4829 2716 4728", "3438 2717 4858 1922", "3729 4728 4716 4786", "3442 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA2817238118271728sjw", "3317 2834 4781 4912", "3582 3821 4711 2131", "3600 0000 0000 0000", "3299 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCardAmericanExpress card = new CreditCardAmericanExpress(input);
            assertEquals(true, card.validCardProvider());
        }

        for (String input : invalidInputs) {
            CreditCardAmericanExpress card = new CreditCardAmericanExpress(input);
            assertEquals(false, card.validCardProvider());
        }
    }

    @Test
    void creditCardValidProviderDinersClubWorks() {
        String[] validInputs = new String[] {"3657623898234113", "3618 4829 2716 4728", "3838 2717 4858 1922", "3829 4728 4716 4786", "3642 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA2817238118271728sjw", "3317 2834 4781 4912", "3582 3821 4711 2131", "3100 0000 0000 0000", "3299 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCardDinersClub card = new CreditCardDinersClub(input);
            assertEquals(true, card.validCardProvider());
        }

        for (String input : invalidInputs) {
            CreditCardDinersClub card = new CreditCardDinersClub(input);
            assertEquals(false, card.validCardProvider());
        }
    }

    @Test
    void creditCardValidProviderDiscoverWorks() {
        String[] validInputs = new String[] {"6011623898234113", "6501 1829 2716 4728", "6522 2717 4858 1922", "6011 4728 4716 4786", "6510 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA6417238118271728sjw", "3657 2834 4781 4912", "3582 6011 4711 2131", "1100 0000 0000 0000", "2399 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCardDiscover card = new CreditCardDiscover(input);
            assertEquals(true, card.validCardProvider());
        }

        for (String input : invalidInputs) {
            CreditCardDiscover card = new CreditCardDiscover(input);
            assertEquals(false, card.validCardProvider());
        }
    }

    @Test
    void creditCardValidProviderJCBWorks() {
        String[] validInputs = new String[] {"3511623898234113", "3501 1829 2716 4728", "3535 2717 4858 1922", "3500 4728 4716 4786", "3522 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA6417358118271728sjw", "9957 2834 4781 4912", "3182 6011 4711 2131", "1350 0000 0000 0000", "0359 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCardJCB card = new CreditCardJCB(input);
            assertEquals(true, card.validCardProvider());
        }

        for (String input : invalidInputs) {
            CreditCardJCB card = new CreditCardJCB(input);
            assertEquals(false, card.validCardProvider());
        }
    }

    @Test
    void creditCardValidProviderMastercardWorks() {
        String[] validInputs = new String[] {"5111623898234113", "5201 1829 2716 4728", "5335 2717 4858 1922", "5400 4728 4716 4786", "5522 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA6017358118271728sjw", "5957 2834 4781 4912", "5082 6011 4711 2131", "1550 0000 0000 0000", "5609 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCardMastercard card = new CreditCardMastercard(input);
            assertEquals(true, card.validCardProvider());
        }

        for (String input : invalidInputs) {
            CreditCardMastercard card = new CreditCardMastercard(input);
            assertEquals(false, card.validCardProvider());
        }
    }

    @Test
    void creditCardValidProviderVisaWorks() {
        String[] validInputs = new String[] {"4457623898234113", "4118 4829 2716 4728", "4238 2717 4858 1922", "4829 4728 4716 4786", "4242 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA2817238118271728sjw", "2817 2834 4781 4912", "0182 3821 4711 2131", "0000 0000 0000 0000", "9999 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCardVisa card = new CreditCardVisa(input);
            assertEquals(true, card.validCardProvider());
        }

        for (String input : invalidInputs) {
            CreditCardVisa card = new CreditCardVisa(input);
            assertEquals(false, card.validCardProvider());
        }
    }

    @Test
    void creditCardValidNumberWorks() {
        String[] validInputs = new String[] {"5457623898234113", "3918 4829 2716 4728", "1238 2717 4858 1922", "5829 4728 4716 4786", "4242 4242 4242 4242"};
        String[] invalidInputs = new String[] {" 😀abcA2817238118271728sjw", "2817 2834 4781 4912", "0182 3821 4711 2131", "0000 0000 0000 0000", "9999 9999 9999 9999"};
        
        for (String input : validInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(true, CreditCard.isValidNumber(card));
        }

        for (String input : invalidInputs) {
            CreditCard card = new CreditCard(input);
            assertEquals(false, CreditCard.isValidNumber(card));
        }
    }
}