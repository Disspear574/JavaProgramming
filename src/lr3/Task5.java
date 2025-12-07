package lr3;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int found = 0, num = 1, sum = 0;

        while (found < count) {
            if (num % 5 == 2 || num % 3 == 1) {
                System.out.print(num + " ");
                sum += num;
                found++;
            }
            num++;
        }
        System.out.println("\nСумма = " + sum);
    }
}