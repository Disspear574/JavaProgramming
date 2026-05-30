package lr9;

import java.util.Scanner;

public class Task3 {
    private static void readArrayRec(Scanner sc, int[] a, int i) {
        if (i >= a.length) return;
        a[i] = sc.nextInt();
        readArrayRec(sc, a, i + 1);
    }

    private static void printArrayRec(int[] a, int i) {
        if (i >= a.length) return;
        System.out.print(a[i]);
        if (i + 1 < a.length) System.out.print(" ");
        printArrayRec(a, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 5;
        if (n < 0) {
            System.out.println("size must be >= 0");
            return;
        }
        int[] a = new int[n];
        if (n > 0) {
            System.out.println("Введите " + n + " целых чисел:");
            readArrayRec(sc, a, 0);
        }
        System.out.println("Массив:");
        printArrayRec(a, 0);
        System.out.println();
    }
}
