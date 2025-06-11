package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try{
            System.out.print("Введите дату последнего полива кактуса в формате DD.MM.YYYY: ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(str, dateTimeFormatter);

            System.out.println("Дата последнего полива: " + date);

            int currentMonth = date.getMonthValue();
            LocalDate dateWatering;

            // Если сейчас зима (декабрь - февраль), то кактус поливается раз в месяц.
            if (currentMonth == 1 || currentMonth == 2 || currentMonth == 12) {
                System.out.println("Сейчас зима. Вам нужно полить кактус в следующем месяце.");
                dateWatering = date.plusMonths(1);
                System.out.println("Дата следующего полива: " + dateWatering);
            }
            // Если осень или весна - раз в неделю.
            else if (currentMonth == 3 || currentMonth == 4 || currentMonth == 5 ||
                    currentMonth == 9 || currentMonth == 10 || currentMonth == 11) {
                System.out.println("Сейчас весна или осень. Вам нужно полить кактус через неделю.");
                dateWatering = date.plusWeeks(1);
                System.out.println("Дата следующего полива: " + dateWatering);
            }
            // Летом поливается в зависимости от влажности воздуха, но не чаще одного раза в два дня.
            else {
                double humidity = Sensor.getHumidity();
                System.out.println("Сейчас лето. Влажность воздуха: " + humidity);

                if (humidity < 30.0) {
                    System.out.println("Влажность меньше 30%. Если влажность через 2 дня будет меньше 30%, то полейте кактус.");
                    dateWatering = date.plusDays(2);
                    System.out.println("Дата возможного полива: " + dateWatering);
                } else {
                    System.out.println("Влажность >= 30%. Проверьте влажность завтра.");
                }
            }
        }
        catch (DateTimeParseException dateTimeParseException){
            System.out.println("Неправильный формат даты! Введите дату в формате: DD.MM.YYYY");
        }

    }
}
