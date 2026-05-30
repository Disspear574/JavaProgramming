package lr9;

import java.util.Scanner;

public class Task5 {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node createHead(int n) {
        Node head = null;
        for (int i = 1; i <= n; i++) {
            head = new Node(i, head);
        }
        return head;
    }

    private static Node createTail(int n) {
        if (n <= 0) return null;
        Node head = new Node(1, null);
        Node tail = head;
        for (int i = 2; i <= n; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
        return head;
    }

    private static String toString(Node head) {
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value);
            if (ref.next != null) sb.append(" -> ");
            ref = ref.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 8;
        if (n < 0) {
            System.out.println("n must be >= 0");
            return;
        }

        Node byHead = createHead(n);
        Node byTail = createTail(n);

        System.out.println("createHead(): " + toString(byHead));
        System.out.println("createTail(): " + toString(byTail));
    }
}
