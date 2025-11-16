package lr1;

import lr1.core.Consts;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите возраст: ");
        int age = sc.nextInt();

        int birth = Consts.CURRENT_YEAR - age;

        System.out.println("Ваш год рождения: " + birth);
    }
}