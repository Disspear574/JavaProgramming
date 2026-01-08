package lr5;

import core.Logger;

import java.util.Scanner;

public class Task3 {

    private static class IntPair {
        private int x;
        private int y;

        public IntPair() {
            this(0, 0);
        }

        public IntPair(int a) {
            this(a, 0);
        }

        public IntPair(int a, int b) {
            x = a;
            y = b;
        }

        public void print() {
            Logger.log("x:" + " " + x);
            Logger.log("y:" + " " + y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();

        IntPair p;
        if (mode == 0) {
            p = new IntPair();
        } else if (mode == 1) {
            int a = sc.nextInt();
            p = new IntPair(a);
        } else {
            int a = sc.nextInt();
            int b = sc.nextInt();
            p = new IntPair(a, b);
        }
        p.print();
    }
}
