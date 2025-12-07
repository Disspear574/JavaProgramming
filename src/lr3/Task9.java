package lr3;

import java.util.Random;

public class Task9 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100);
            System.out.print(arr[i] + " ");
        }

        int min = arr[0];
        for (int x : arr) if (x < min) min = x;

        System.out.println("\nМинимум: " + min);
        System.out.print("Индексы: ");
        for (int i = 0; i < arr.length; i++) if (arr[i] == min) System.out.print(i + " ");
    }
}