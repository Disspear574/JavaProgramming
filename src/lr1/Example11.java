package lr1;

import core.Consts;

import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = sc.nextLine();

        System.out.print("Введите год рождения: ");
        int birth = sc.nextInt();

        int age = Consts.CURRENT_YEAR - birth;

        System.out.println(name + ", вам " + age + " лет.");
    }
}
