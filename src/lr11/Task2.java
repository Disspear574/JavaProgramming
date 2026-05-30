package lr11;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static int[] intersection(int[] a, int[] b) {
        Set<Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(set::contains).distinct().toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 7, 8};
        System.out.println(Arrays.toString(intersection(a, b)));
    }
}
