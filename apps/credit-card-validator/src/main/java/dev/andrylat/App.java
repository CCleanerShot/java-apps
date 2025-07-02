package dev.andrylat;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Validator! Please enter your 16 digit card number:");
        scanner.nextLine();
        scanner.close();
    }
}
