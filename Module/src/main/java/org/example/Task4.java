package org.example;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws Exception {

        int userScore = 0;
        int computerScore = 0;

        for (int i = 1; i < 6; i++) {
            System.out.println("Раунд " + i);
            System.out.print("Введите одно из значений: К - камень, Н - ножницы, Б - бумага: ");
            Scanner scanner = new Scanner(System.in);
            String userValue = scanner.nextLine();
            System.out.print("Значение пользователя: " + userValue);


            if (!userValue.equals("К") && !userValue.equals("Н") && !userValue.equals("Б"))
                throw new IllegalArgumentException("Введено некорректное значение!");

            Random random = new Random();
            int computerIntValue = random.nextInt(3) + 1;
            String computerValue;
            if (computerIntValue == 1) computerValue = "К";
            else if (computerIntValue == 2) computerValue = "Н";
            else computerValue = "Б";
            System.out.println(". Значение компьютера: " + computerValue);

            // Правила:
            // Камень (К) ломает ножницы (Н)
            // Ножницы (Н) режут бумагу (Б)
            // Бумага (Б) заворачивает камень (К)

            // Камень (К) ломает ножницы (Н)
            if (userValue.equals("К") && computerValue.equals("Н")) {
                userScore += 1;
                System.out.println("Камень юзера ломает ножницы компьютера. +1 юзеру");
            }
            else if (computerValue.equals("К") && userValue.equals("Н")) {
                computerScore += 1;
                System.out.println("Камень компьютера ломает ножницы юзера. +1 компьютеру");
            }

            // Ножницы (Н) режут бумагу (Б)
            else if (userValue.equals("Н") && computerValue.equals("Б")) {
                userScore += 2;
                System.out.println("Ножницы юзера режут бумагу компьютера. +2 юзеру");
            } else if (computerValue.equals("Н") && userValue.equals("Б")) {
                computerScore += 2;
                System.out.println("Ножницы компьютера режут бумагу юзера. +2 компьютеру");
            }

            // Бумага (Б) заворачивает камень (К)
            else if (userValue.equals("Б") && computerValue.equals("К")) {
                userScore += 5;
                System.out.println("Бумага юзера заворачивает камень компьютера. +5 юзеру");
            } else if (computerValue.equals("Б") && userValue.equals("К")) {
                computerScore += 5;
                System.out.println("Бумага компьютера заворачивает камень юзера. +5 компьютеру");
            } else System.out.println("Ничья");
        }
        System.out.println("Итоговый счёт: " +
                "\n\t Количество очков юзера: " + userScore +
                "\n\t Количество очков компьютера: " + computerScore);
        if (userScore > computerScore) System.out.println("Победу одержал юзер");
        else if (computerScore > userScore) System.out.println("Победу одержал компьютер");
        else System.out.println("Ничья");
    }
}
