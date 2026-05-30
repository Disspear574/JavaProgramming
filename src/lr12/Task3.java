package lr12;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        final int max = 10;
        final int[] number = {1};

        Thread even = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (number[0] <= max && number[0] % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if (number[0] > max) {
                        lock.notifyAll();
                        return;
                    }
                    System.out.println("even: " + number[0]++);
                    lock.notifyAll();
                }
            }
        });

        Thread odd = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (number[0] <= max && number[0] % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if (number[0] > max) {
                        lock.notifyAll();
                        return;
                    }
                    System.out.println("odd: " + number[0]++);
                    lock.notifyAll();
                }
            }
        });

        odd.start();
        even.start();
        odd.join();
        even.join();
    }
}
