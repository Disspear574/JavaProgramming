package lr3;

import java.util.Arrays;
import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }

        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i] + " ");
    }
}