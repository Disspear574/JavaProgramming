package lr11;

import java.util.Arrays;

public class Task1 {
    public static int[] onlyEven(int[] a) {
        return Arrays.stream(a).filter(x -> x % 2 == 0).toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(onlyEven(a)));
    }
}
