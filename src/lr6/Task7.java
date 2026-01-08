package lr6;

import core.Logger;

import java.util.Scanner;

public class Task7 {

    public static int[] toCodes(char[] a) {
        if (a == null) return null;
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) res[i] = (int) a[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a = s.toCharArray();

        int[] codes = toCodes(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.length; i++) {
            sb.append(codes[i]);
            if (i + 1 < codes.length) sb.append(" ");
        }
        Logger.log(sb.toString());
    }
}
