package lr6;

import core.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {

    public static int[] takeFirst(int[] a, int k) {
        if (a == null) return null;
        if (k >= a.length) return Arrays.copyOf(a, a.length);
        if (k <= 0) return new int[0];
        return Arrays.copyOf(a, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int k = sc.nextInt();

        int[] b = takeFirst(a, k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
            if (i + 1 < b.length) sb.append(" ");
        }
        Logger.log(sb.toString());
    }
}
