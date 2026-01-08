package lr6;

import core.Logger;

import java.util.Scanner;

public class Task4 {

    public static long doubleFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        long res = 1;
        for (int k = n; k >= 2; k -= 2) res *= k;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Logger.log("n!!:" + " " + doubleFactorial(n));
    }
}
