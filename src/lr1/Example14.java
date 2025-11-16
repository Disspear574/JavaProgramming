package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");
        int b = sc.nextInt();

        int a = b - 1;
        int c = b + 1;

        int d = (a + b + c) * (a + b + c);

        System.out.println(a + " " + b + " " + c + " " + d);
    }
}