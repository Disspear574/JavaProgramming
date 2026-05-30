package lr9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    private static int josephus(List<Integer> people) {
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    private static List<Integer> initPeople(int n, boolean linked) {
        List<Integer> list = linked ? new LinkedList<>() : new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 10000;
        if (n <= 0) {
            System.out.println("n must be > 0");
            return;
        }

        List<Integer> arr = initPeople(n, false);
        long t1 = System.nanoTime();
        int winnerArrayList = josephus(arr);
        long t2 = System.nanoTime();

        List<Integer> lin = initPeople(n, true);
        long t3 = System.nanoTime();
        int winnerLinkedList = josephus(lin);
        long t4 = System.nanoTime();

        long arrayTimeNs = (t2 - t1);
        long linkedTimeNs = (t4 - t3);
        long arrayTimeMs = arrayTimeNs / 1_000_000;
        long linkedTimeMs = linkedTimeNs / 1_000_000;

        System.out.println("Победитель (ArrayList): " + winnerArrayList);
        System.out.println("Победитель (LinkedList): " + winnerLinkedList);
        System.out.println("ArrayList time (ms): " + arrayTimeMs);
        System.out.println("LinkedList time (ms): " + linkedTimeMs);
        System.out.println("ArrayList time (ns): " + arrayTimeNs);
        System.out.println("LinkedList time (ns): " + linkedTimeNs);

        if (arrayTimeMs < linkedTimeMs) {
            System.out.println("Быстрее ArrayList: доступ по индексу и удаление в этой модели обычно выгоднее.");
        } else if (arrayTimeMs > linkedTimeMs) {
            System.out.println("Быстрее LinkedList: для текущего N удаление оказалось дешевле.");
        } else {
            System.out.println("Время совпало: на данном N разница незначительна (увеличьте N для более наглядного сравнения).");
        }
    }
}
