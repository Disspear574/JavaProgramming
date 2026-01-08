package lr6;

import core.Logger;

import java.util.Scanner;

public class Task3 {

    private static class Stats {

        public static int max(int... nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            int m = nums[0];
            for (int x : nums) {
                if (x > m) m = x;
            }
            return m;
        }

        public static int min(int... nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            int m = nums[0];
            for (int x : nums) {
                if (x < m) m = x;
            }
            return m;
        }

        public static double avg(int... nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            long sum = 0;
            for (int x : nums) {
                sum += x;
            }
            return (double) sum / nums.length;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Logger.log("max:" + " " + Stats.max(a));
        Logger.log("min:" + " " + Stats.min(a));
        Logger.log("avg:" + " " + Stats.avg(a));
    }
}
