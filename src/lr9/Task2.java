package lr9;

import java.util.Scanner;

public class Task2 {
    private static String toBinaryRec(int n) {
        if (n == 0) return "0";
        if (n < 0) return "-" + toBinaryPositive(-(long) n);
        return toBinaryPositive(n);
    }

    private static String toBinaryPositive(long n) {
        if (n == 0) return "";
        return toBinaryPositive(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.hasNextInt() ? sc.nextInt() : 42;
        System.out.println("binary = " + toBinaryRec(value));
    }
}
