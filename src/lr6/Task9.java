package lr6;

import core.Logger;

import java.util.Scanner;

public class Task9 {

    public static void reverseSwap(char[] a) {
        if (a == null) return;
        int i = 0, j = a.length - 1;
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a = s.toCharArray();

        reverseSwap(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i + 1 < a.length) sb.append(" ");
        }
        Logger.log(sb.toString());
    }
}
