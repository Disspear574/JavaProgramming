package lr1;

import lr1.core.Consts;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите год рождения: ");
        int birth = sc.nextInt();

        int age = Consts.CURRENT_YEAR - birth;

        System.out.println("Ваш возраст: " + age);
    }
}