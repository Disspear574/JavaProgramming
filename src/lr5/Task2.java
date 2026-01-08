package lr5;

import core.Logger;

import java.util.Scanner;

public class Task2 {

    private static class CharRange {
        private char a;
        private char b;

        public CharRange(char a, char b) {
            this.a = a;
            this.b = b;
        }

        public String showBetween() {
            int start = Math.min(a, b);
            int end = Math.max(a, b);

            StringBuilder sb = new StringBuilder();
            for (int code = start; code <= end; code++) {
                sb.append((char) code);
                if (code != end) sb.append(" ");
            }
            Logger.log(sb.toString());
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);

        CharRange r = new CharRange(c1, c2);
        r.showBetween();
    }
}
