package lr5;

import core.Logger;

import java.util.Scanner;

public class Task6 {
    private static class MinMaxBox {
        private int max;
        private int min;
        public MinMaxBox() {
            max = 0;
            min = 0;
        }
        public MinMaxBox(int a) {
            this();
            set(a);
        }
        public MinMaxBox(int a, int b) {
            this();
            set(a, b);
        }
        public void set(int a) {
            int newMax = Math.max(Math.max(max, min), a);
            int newMin = Math.min(Math.min(max, min), a);
            max = newMax;
            min = newMin;
        }
        public void set(int a, int b) {
            int currentMax = Math.max(max, min);
            int currentMin = Math.min(max, min);

            int newMax = Math.max(currentMax, Math.max(a, b));
            int newMin = Math.min(currentMin, Math.min(a, b));

            max = newMax;
            min = newMin;
        }
        public void print() {
            Logger.log("min:" + " " + min);
            Logger.log("max:" + " " + max);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        MinMaxBox box;
        if (mode == 0) {
            box = new MinMaxBox();
        } else if (mode == 1) {
            int a = sc.nextInt();
            box = new MinMaxBox(a);
        } else {
            int a = sc.nextInt();
            int b = sc.nextInt();
            box = new MinMaxBox(a, b);
        }
        int setMode = sc.nextInt();
        if (setMode == 1) {
            int a = sc.nextInt();
            box.set(a);
        } else if (setMode == 2) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            box.set(a, b);
        }
        box.print();
    }
}
