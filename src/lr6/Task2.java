package lr6;

import core.Logger;

import java.util.Scanner;

public class Task2 {

    private static class Counter {
        private static int value = 0;

        public static void showAndInc() {
            Logger.log("value:" + " " + value);
            value++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            Counter.showAndInc();
        }
    }
}
