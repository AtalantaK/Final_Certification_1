package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите целочисленные элементы массива. Для завершения ввода нажмите Enter и Ctrl+D.");
        System.out.print("Ожидаем элементы массива: ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        System.out.println("Ввод завершён. Введённые числа: " + arrayList);

        int max = arrayList.get(0);
        int secondMax = arrayList.get(0);

        for (Integer integer : arrayList) {
            if (integer > max) max = integer;
        }
        for (Integer integer : arrayList) {
            if (integer > secondMax && integer < max) secondMax = integer;
        }

        System.out.println("Максимальное значение: " + max);
        System.out.println("Второе по величине максимальное значение: " + secondMax);
    }
}