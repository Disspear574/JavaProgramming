package lr9;

import java.util.Arrays;
import java.util.Scanner;

public class Task8 {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class SingleList {
        private Node head;

        public void clear() {
            head = null;
        }

        // Итеративные методы
        public void createHead(int[] a) {
            clear();
            for (int x : a) addFirst(x);
        }

        public void createTail(int[] a) {
            clear();
            for (int x : a) addLast(x);
        }

        public void addFirst(int x) {
            head = new Node(x, head);
        }

        public void addLast(int x) {
            Node newNode = new Node(x, null);
            if (head == null) {
                head = newNode;
                return;
            }
            Node ref = head;
            while (ref.next != null) ref = ref.next;
            ref.next = newNode;
        }

        public void insert(int index, int x) {
            if (index <= 0 || head == null) {
                addFirst(x);
                return;
            }
            Node ref = head;
            int i = 0;
            while (ref.next != null && i < index - 1) {
                ref = ref.next;
                i++;
            }
            ref.next = new Node(x, ref.next);
        }

        public Integer removeFirst() {
            if (head == null) return null;
            int value = head.value;
            head = head.next;
            return value;
        }

        public Integer removeLast() {
            if (head == null) return null;
            if (head.next == null) {
                int value = head.value;
                head = null;
                return value;
            }
            Node ref = head;
            while (ref.next.next != null) ref = ref.next;
            int value = ref.next.value;
            ref.next = null;
            return value;
        }

        public Integer remove(int index) {
            if (head == null) return null;
            if (index <= 0) return removeFirst();

            Node ref = head;
            int i = 0;
            while (ref.next != null && i < index - 1) {
                ref = ref.next;
                i++;
            }
            if (ref.next == null) return null;
            int value = ref.next.value;
            ref.next = ref.next.next;
            return value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node ref = head;
            while (ref != null) {
                sb.append(ref.value);
                if (ref.next != null) sb.append(" ");
                ref = ref.next;
            }
            return sb.toString();
        }

        // Рекурсивные методы
        public void createHeadRec(int[] a) {
            clear();
            createHeadRec(a, 0);
        }

        private void createHeadRec(int[] a, int i) {
            if (i >= a.length) return;
            addFirst(a[i]);
            createHeadRec(a, i + 1);
        }

        public void createTailRec(int[] a) {
            clear();
            createTailRec(a, 0);
        }

        private void createTailRec(int[] a, int i) {
            if (i >= a.length) return;
            addLast(a[i]);
            createTailRec(a, i + 1);
        }

        public String toStringRec() {
            StringBuilder sb = new StringBuilder();
            toStringRec(head, sb);
            return sb.toString();
        }

        private void toStringRec(Node node, StringBuilder sb) {
            if (node == null) return;
            sb.append(node.value);
            if (node.next != null) sb.append(" ");
            toStringRec(node.next, sb);
        }
    }

    private static int[] readArray(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 5;
        int[] a;
        if (n > 0 && sc.hasNextInt()) {
            a = readArray(sc, n);
        } else {
            a = new int[]{1, 2, 3, 4, 5};
        }

        SingleList list = new SingleList();
        list.createHead(a);
        System.out.println("createHead: " + list);

        list.createTail(a);
        System.out.println("createTail: " + list);

        list.addFirst(99);
        list.addLast(77);
        list.insert(2, 55);
        System.out.println("after AddFirst/AddLast/Insert: " + list);

        list.removeFirst();
        list.removeLast();
        list.remove(2);
        System.out.println("after RemoveFirst/RemoveLast/Remove: " + list);

        list.createHeadRec(a);
        System.out.println("createHeadRec: " + list.toStringRec());

        list.createTailRec(a);
        System.out.println("createTailRec: " + list.toStringRec());

        System.out.println("input data: " + Arrays.toString(a));
    }
}
