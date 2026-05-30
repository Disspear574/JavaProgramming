package lr9;

import java.util.Scanner;

public class Task1 {
    private static void seqForward(int x) {
        if (x < 0 || x >= 20) return;
        System.out.print(x + " ");
        seqForward(2 * x + 1);
    }

    private static void seqReverse(int x) {
        if (x < 0 || x >= 20) return;
        seqReverse(2 * x + 1);
        System.out.print(x + " ");
    }

    private static void seqTrace(int x) {
        if (x < 0 || x >= 20) return;
        System.out.println("enter x=" + x);
        seqTrace(2 * x + 1);
        System.out.println("exit x=" + x);
    }

    private static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    private static long fib(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static long fibTrace(int n, int depth) {
        String indent = "  ".repeat(Math.max(0, depth));
        System.out.println(indent + "fib(" + n + ")");
        if (n <= 1) {
            System.out.println(indent + "return " + n);
            return n;
        }
        long left = fibTrace(n - 1, depth + 1);
        long right = fibTrace(n - 2, depth + 1);
        long sum = left + right;
        System.out.println(indent + "return " + sum + " from fib(" + n + ")");
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.hasNextInt() ? sc.nextInt() : 1;
        int nFact = sc.hasNextInt() ? sc.nextInt() : 5;
        int nFib = sc.hasNextInt() ? sc.nextInt() : 6;

        System.out.println("Example 1 (forward):");
        seqForward(x);
        System.out.println();

        System.out.println("Example 2 (reverse):");
        seqReverse(x);
        System.out.println();

        System.out.println("Example 3 (trace enter/exit):");
        seqTrace(x);

        System.out.println("Example 4 (factorial):");
        System.out.println(nFact + "! = " + factorial(nFact));

        System.out.println("Example 5 (fibonacci):");
        System.out.println("fib(" + nFib + ") = " + fib(nFib));
        System.out.println("Traversal of recursion tree:");
        fibTrace(nFib, 0);
    }
}
