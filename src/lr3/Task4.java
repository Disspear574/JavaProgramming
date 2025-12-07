package lr3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean useFor = sc.nextBoolean();

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (useFor) printRangeFor(min, max);
        else printRangeWhile(min, max);
    }

    static void printRangeFor(int min, int max) {
        for (int i = min; i <= max; i++) System.out.print(i + " ");
    }

    static void printRangeWhile(int min, int max) {
        while (min <= max) {
            System.out.print(min + " ");
            min++;
        }
    }
}