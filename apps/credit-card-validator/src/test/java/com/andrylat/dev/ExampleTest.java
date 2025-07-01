package com.andrylat.dev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    void creditCardValidatorWorks() {
        CreditCardValidator validator = new CreditCardValidator();
        assertEquals(validator.CardValid(1), false, "CardValid(1) should equal false");
    }
}