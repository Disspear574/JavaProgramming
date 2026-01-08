package lr6;

import core.Logger;

import java.util.Scanner;

public class Task1 {

    private static class DuoField {
        private char ch;
        private String text;

        public void setValue(char c) {
            ch = c;
        }

        public void setValue(String s) {
            text = s;
        }

        public void setValue(char[] arr) {
            if (arr == null || arr.length == 0) return;
            if (arr.length == 1) {
                ch = arr[0];
            } else {
                text = new String(arr);
            }
        }

        public void print() {
            Logger.log("char:" + " " + ch);
            Logger.log("text:" + " " + text);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mode = sc.nextInt();
        DuoField obj = new DuoField();

        if (mode == 1) {
            char c = sc.next().charAt(0);
            obj.setValue(c);
        } else if (mode == 2) {
            String s = sc.next();
            obj.setValue(s);
        } else {
            String s = sc.next();
            obj.setValue(s.toCharArray());
        }

        obj.print();
    }
}
