package dev.andrylat.ccleanershot.creditcard_validator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

import dev.andrylat.ccleanershot.creditcard_validator.creditcard.CreditCard;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) { 
                System.out.println("> Welcome to the Credit Card Validator! Please enter your 16 digit card number (type 'exit' to leave):");
                String input = scanner.nextLine();

                if(input.equals("exit")) {
                    break;
                }

                CreditCard card = new CreditCard(input);
                ArrayList<String> errors = card.getErrors();

                if(!errors.isEmpty()) {
                    System.out.println("> ERRORS:");

                    for (String error : errors) {
                        System.out.println(MessageFormat.format("  - {0}", error));
                    }
                } else {
                    System.out.println(MessageFormat.format("> The card is valid. Card Provider: {0}", card.getCardProvider()));
                }
        }

        } catch (Exception ex) {
            System.err.println(MessageFormat.format("Unhandled exception: {0}", ex));
        }
    }
}
