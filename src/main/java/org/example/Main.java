package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.readCard(LocalDate.of(2021, 5, 1), "1234 1234 1234 1234");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите PIN:");

        int pin = sc.nextInt();
        try {
            atm.readPin(pin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        String balance = atm.getBalance();
        System.out.println(balance);
    }
}
