package dev.andrylat;

import java.text.MessageFormat;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Credit Card Validator! Please enter your 16 digit card number:");
            String input = scanner.nextLine();
            
            
        } catch (Exception err) {
            System.err.println(MessageFormat.format("Unhandled exception: {0}", err));
        }
    }
}
