package lr9;

public class Task4 {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node buildIndependentAndLink(int n) {
        if (n <= 0) return null;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, null);
        }
        for (int i = 0; i + 1 < n; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    private static String listToString(Node head) {
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
        int n = 8;
        Node head = buildIndependentAndLink(n);
        System.out.println("Односвязный список из независимых узлов:");
        System.out.println(listToString(head));
    }
}
