package lr12;

import java.time.LocalTime;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable worker = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        Thread t1 = new Thread(worker, "Thread-1");
        Thread t2 = new Thread(worker, "Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
