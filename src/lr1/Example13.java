package lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = sc.nextInt();

        System.out.print("Введите второе число: ");
        int b = sc.nextInt();

        int sum = a + b;

        System.out.println("Сумма = " + sum);
    }
}