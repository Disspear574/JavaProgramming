package lr13;

public class Task1 {
    private static void ex1() {
        try {
            throw new RuntimeException("ex1");
        } catch (RuntimeException e) {
            System.out.println("ex1: " + e.getMessage());
        }
    }

    private static void ex2() {
        try {
            throw new IllegalArgumentException("ex2");
        } catch (Exception e) {
            System.out.println("ex2: " + e.getClass().getSimpleName());
        }
    }

    private static void ex3() {
        try {
            int x = 10 / 0;
            System.out.println(x);
        } catch (ArithmeticException e) {
            System.out.println("ex3: division by zero");
        }
    }

    private static void ex4() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("ex4: null pointer");
        }
    }

    private static void ex5() {
        try {
            int[] a = {1};
            System.out.println(a[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ex5: out of bounds");
        }
    }

    private static void ex6() {
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("ex6: number format");
        }
    }

    private static void ex7() {
        try {
            Object x = "text";
            Integer n = (Integer) x;
            System.out.println(n);
        } catch (ClassCastException e) {
            System.out.println("ex7: class cast");
        }
    }

    private static void ex8() throws Exception {
        throw new Exception("checked ex8");
    }

    private static void ex9() {
        try {
            ex8();
        } catch (Exception e) {
            System.out.println("ex9: caught checked -> " + e.getMessage());
        }
    }

    private static void ex10() {
        try {
            System.out.println("ex10 try");
            return;
        } finally {
            System.out.println("ex10 finally");
        }
    }

    private static void ex11() {
        try {
            throw new IllegalStateException("bad state");
        } catch (IllegalStateException e) {
            System.out.println("ex11: " + e.getMessage());
        } finally {
            System.out.println("ex11 finally");
        }
    }

    private static void ex12(int x) {
        if (x < 0) throw new IllegalArgumentException("x must be >= 0");
        System.out.println("ex12 x=" + x);
    }

    private static void ex13(String[] args) {
        try {
            System.out.println("ex13 first arg: " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ex13: no args");
        }
    }

    private static void ex14(int x) throws ArithmeticException {
        int y = 10 / x;
        System.out.println("ex14 y=" + y);
    }

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
        ex9();
        ex10();
        ex11();

        try {
            ex12(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("ex12: " + e.getMessage());
        }

        ex13(args);
        try {
            ex14(0);
        } catch (ArithmeticException e) {
            System.out.println("ex14: division by zero");
        }
    }
}
