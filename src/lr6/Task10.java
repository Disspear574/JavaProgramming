package lr6;

import core.Logger;

import java.util.Scanner;

public class Task10 {

    public static int[] minMax(int... nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int mn = nums[0];
        int mx = nums[0];

        for (int x : nums) {
            if (x < mn) mn = x;
            if (x > mx) mx = x;
        }
        return new int[]{mx, mn};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] res = minMax(a);

        if (res.length == 2) {
            Logger.log("max:" + " " + res[0]);
            Logger.log("min:" + " " + res[1]);
        } else {
            Logger.log("empty");
        }
    }
}
