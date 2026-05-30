package lr11;

import java.util.List;

public class Task8 {
    public static List<Integer> greaterThan(List<Integer> in, int threshold) {
        return in.stream().filter(x -> x > threshold).toList();
    }

    public static void main(String[] args) {
        System.out.println(greaterThan(List.of(1, 10, 3, 15, 8), 7));
    }
}
