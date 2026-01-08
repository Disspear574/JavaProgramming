package lr7;

import core.Logger;

import java.util.Scanner;

public class Task3 {

    private static class A {
        public int x;

        public A(int x) {
            this.x = x;
        }

        public void set(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "x=" + x;
        }
    }

    private static class B extends A {
        public char ch;

        public B(int x, char ch) {
            super(x);
            this.ch = ch;
        }

        public void set(int x, char ch) {
            super.set(x);
            this.ch = ch;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "x=" + x + " " + "ch=" + ch;
        }
    }

    private static class C extends B {
        public String text;

        public C(int x, char ch, String text) {
            super(x, ch);
            this.text = text;
        }

        public void set(int x, char ch, String text) {
            super.set(x, ch);
            this.text = text;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + "x=" + x + " " + "ch=" + ch + " " + "text=" + text;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        char ch = sc.next().charAt(0);
        sc.nextLine();
        String t = sc.nextLine();

        A a = new A(x);
        B b = new B(x, ch);
        C c = new C(x, ch, t);

        Logger.log(a.toString());
        Logger.log(b.toString());
        Logger.log(c.toString());
    }
}
