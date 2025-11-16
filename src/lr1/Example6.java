package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите фамилию: ");
        String last = sc.nextLine();

        System.out.print("Введите имя: ");
        String first = sc.nextLine();

        System.out.print("Введите отчество: ");
        String middle = sc.nextLine();

        System.out.println("Hello " + last + " " + first + " " + middle);
    }
}