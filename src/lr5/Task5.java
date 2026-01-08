package lr5;

import core.Logger;

import java.util.Scanner;

public class Task5 {

    private static class LimitedInt {
        private int value;
        public LimitedInt() {
            setValue();
        }
        public LimitedInt(int v) {
            setValue(v);
        }
        public void setValue() {
            value = 0;
        }
        public void setValue(int v) {
            value = Math.min(v, 100);
        }
        public int getValue() {
            return value;
        }
        public void print() {
            Logger.log("value:" + " " + value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();

        LimitedInt obj;
        if (mode == 0) {
            obj = new LimitedInt();
        } else {
            int v = sc.nextInt();
            obj = new LimitedInt(v);
        }

        int setMode = sc.nextInt();
        if (setMode == 0) {
            obj.setValue();
        } else {
            int v = sc.nextInt();
            obj.setValue(v);
        }

        obj.print();
        Logger.log("check:" + " " + obj.getValue());
    }
}
