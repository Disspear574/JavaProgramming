package lr7;

import core.Logger;

import java.util.Scanner;

public class Task4 {

    private static class A {
        public char ch;

        public A(char ch) {
            this.ch = ch;
        }

        public A(A other) {
            this.ch = other.ch;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "ch=" + ch;
        }
    }

    private static class B extends A {
        public String text;

        public B(char ch, String text) {
            super(ch);
            this.text = text;
        }

        public B(B other) {
            super(other);
            this.text = other.text;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "ch=" + ch + " " + "text=" + text;
        }
    }

    private static class C extends B {
        public int number;

        public C(char ch, String text, int number) {
            super(ch, text);
            this.number = number;
        }

        public C(C other) {
            super(other);
            this.number = other.number;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "ch=" + ch + " " + "text=" + text + " " + "number=" + number;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = sc.next().charAt(0);
        sc.nextLine();
        String text = sc.nextLine();
        int number = Integer.parseInt(sc.nextLine().trim());

        C obj = new C(ch, text, number);
        C copy = new C(obj);

        Logger.log(obj.toString());
        Logger.log(copy.toString());
    }
}
