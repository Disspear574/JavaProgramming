package lr6;

import core.Logger;

import java.util.Scanner;

public class Task5 {

    public static long sumSquares(int n) {
        if (n < 1) return 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) sum += (long) i * i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Logger.log("sum:" + " " + sumSquares(n));
    }
}
