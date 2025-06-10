package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.printf("Введите длину забора (в сантиметрах): ");

        try {
            Scanner scanner = new Scanner(System.in);
            int fenceLength = scanner.nextInt();

            // 15 букв
            int numberLetters = 15;

            // 3 пробела
            int numberSpaces = 3;

            // 62 см на каждые три буквы
            int letterLength = 62;

            // 12 см на каждый пробел
            int letterSpace = 12;

            if ((numberLetters / 3 * letterLength) + (numberSpaces * letterSpace) > fenceLength)
                System.out.println("Надпись не поместится на забор!");
            else System.out.println("Надпись поместится на забор.");
        } catch (InputMismatchException exception) {
            System.out.println("Введите целое число!");
        }
    }
}
