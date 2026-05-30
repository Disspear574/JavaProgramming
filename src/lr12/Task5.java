package lr12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Task5 {
    public static int parallelMax(int[] a) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = Math.max(1, cores);
        AtomicInteger globalMax = new AtomicInteger(Integer.MIN_VALUE);
        List<Thread> threads = new ArrayList<>();

        int chunk = (a.length + threadsCount - 1) / threadsCount;
        for (int t = 0; t < threadsCount; t++) {
            int from = t * chunk;
            int to = Math.min(a.length, from + chunk);
            if (from >= to) break;
            Thread thread = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int i = from; i < to; i++) localMax = Math.max(localMax, a[i]);
                int finalLocalMax = localMax;
                globalMax.updateAndGet(x -> Math.max(x, finalLocalMax));
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread th : threads) th.join();
        return globalMax.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[100_000];
        Random rnd = new Random(42);
        for (int i = 0; i < a.length; i++) a[i] = rnd.nextInt(1_000_000);
        System.out.println("max = " + parallelMax(a));
    }
}
