package lr3;

import java.util.Scanner;


public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean useFor = sc.nextBoolean();

        if (useFor) printFiboFor(n);
        else printFiboWhile(n);
    }

    static void printFiboFor(int n) {
        int a = 1, b = 1;
        if (n >= 1) System.out.print(a + " ");
        if (n >= 2) System.out.print(b + " ");
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    static void printFiboWhile(int n) {
        int a = 1, b = 1;
        int i = 1;
        while (i <= n) {
            if (i == 1) System.out.print(a + " ");
            else if (i == 2) System.out.print(b + " ");
            else {
                int c = a + b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
            i++;
        }
    }
}