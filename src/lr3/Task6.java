package lr3;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Ошибка");
            return;
        }
        int[] arr = new int[n];
        int value = 2;
        for (int i = 0; i < n; i++) {
            arr[i] = value;
            value += 5;
        }
        for (int x : arr) System.out.print(x + " ");
    }
}