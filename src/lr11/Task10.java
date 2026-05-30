package lr11;

import java.util.List;

public class Task10 {
    public static List<Integer> lessThan(List<Integer> in, int threshold) {
        return in.stream().filter(x -> x < threshold).toList();
    }

    public static void main(String[] args) {
        System.out.println(lessThan(List.of(2, 9, 1, 7, 3), 5));
    }
}
