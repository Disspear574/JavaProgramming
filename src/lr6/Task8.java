package lr6;

import core.Logger;

import java.util.Scanner;

public class Task8 {

    public static double avg(int[] a) {
        if (a == null || a.length == 0) return 0.0;
        long sum = 0;
        for (int x : a) sum += x;
        return (double) sum / a.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        Logger.log("avg:" + " " + avg(a));
    }
}
