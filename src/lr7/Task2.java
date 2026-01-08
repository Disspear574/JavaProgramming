package lr7;

import core.Logger;

import java.util.Scanner;

public class Task2 {

    private static class Base {
        private String text;

        public Base(String text) {
            this.text = text;
        }

        public void setValue(String text) {
            this.text = text;
        }

        public int length() {
            return text == null ? 0 : text.length();
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + text;
        }
    }

    private static class Child extends Base {
        public int number;

        public Child(int number, String text) {
            super(text);
            this.number = number;
        }

        public void setValue() {
            setValue("", 0);
        }

        @Override
        public void setValue(String text) {
            setValue(text, this.number);
        }

        public void setValue(int number) {
            setValue(getTextSafe(), number);
        }

        public void setValue(String text, int number) {
            super.setValue(text);
            this.number = number;
        }

        private String getTextSafe() {
            String s = super.toString();
            int idx = s.indexOf(" ");
            if (idx < 0) return "";
            return s.substring(idx + 1);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "text=" + getTextSafe() + " " + "number=" + number;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String baseText = sc.nextLine();
        Base b = new Base(baseText);
        Logger.log("len:" + " " + b.length());

        int n = Integer.parseInt(sc.nextLine().trim());
        String t = sc.nextLine();

        Child c = new Child(n, t);

        Logger.log(c.toString());
        c.setValue();
        Logger.log(c.toString());

        c.setValue("abc");
        Logger.log(c.toString());

        c.setValue(77);
        Logger.log(c.toString());

        c.setValue("zzz", 5);
        Logger.log(c.toString());
    }
}
