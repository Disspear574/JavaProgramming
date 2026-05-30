package lr12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Task6 {
    public static long parallelSum(int[] a) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = Math.max(1, cores);
        AtomicLong total = new AtomicLong(0L);
        List<Thread> threads = new ArrayList<>();

        int chunk = (a.length + threadsCount - 1) / threadsCount;
        for (int t = 0; t < threadsCount; t++) {
            int from = t * chunk;
            int to = Math.min(a.length, from + chunk);
            if (from >= to) break;
            Thread thread = new Thread(() -> {
                long local = 0;
                for (int i = from; i < to; i++) local += a[i];
                total.addAndGet(local);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread th : threads) th.join();
        return total.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[100_000];
        Random rnd = new Random(7);
        for (int i = 0; i < a.length; i++) a[i] = rnd.nextInt(1000);
        System.out.println("sum = " + parallelSum(a));
    }
}
