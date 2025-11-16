package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите день недели: ");
        String day = sc.nextLine();

        System.out.print("Введите месяц: ");
        String month = sc.nextLine();

        System.out.print("Введите дату (число): ");
        int date = sc.nextInt();

        System.out.println("Сегодня: " + day + ", " + date + " " + month);
    }
}