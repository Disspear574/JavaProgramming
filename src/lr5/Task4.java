package lr5;

import core.Logger;

import java.util.Scanner;

public class Task4 {

    private static class Mixed {
        private char ch;
        private int num;

        public Mixed(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }

        public Mixed(double d) {
            int code = (int) Math.floor(d);
            double frac = d - code;
            int val = (int) Math.floor(frac * 100.0 + 1e-9);
            ch = (char) code;
            num = val;
        }

        public void print() {
            Logger.log("char:" + " " + ch);
            Logger.log("code:" + " " + (int) ch);
            Logger.log("int:" + " " + num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();

        Mixed m;
        if (mode == 1) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            m = new Mixed(n, c);
        } else {
            double d = sc.nextDouble();
            m = new Mixed(d);
        }
        m.print();
    }
}
