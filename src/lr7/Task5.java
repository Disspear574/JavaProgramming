package lr7;

import core.Logger;

import java.util.Scanner;

public class Task5 {

    private static class Base {
        private String text;

        public Base(String text) {
            this.text = text;
        }

        public void show() {
            Logger.log(getClass().getSimpleName() + " " + text);
        }

        protected String getText() {
            return text;
        }
    }

    private static class ChildInt extends Base {
        protected int number;

        public ChildInt(String text, int number) {
            super(text);
            this.number = number;
        }

        @Override
        public void show() {
            Logger.log(getClass().getSimpleName() + " " + getText() + " " + number);
        }
    }

    private static class ChildChar extends Base {
        protected char ch;

        public ChildChar(String text, char ch) {
            super(text);
            this.ch = ch;
        }

        @Override
        public void show() {
            Logger.log(getClass().getSimpleName() + " " + getText() + " " + ch);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String t1 = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine().trim());

        String t2 = sc.nextLine();
        char c = sc.nextLine().charAt(0);

        Base b = new Base(t1);
        ChildInt ci = new ChildInt(t1, n);
        ChildChar cc = new ChildChar(t2, c);

        b.show();
        ci.show();
        cc.show();

        Base ref1 = ci;
        Base ref2 = cc;

        ref1.show();
        ref2.show();
    }
}
