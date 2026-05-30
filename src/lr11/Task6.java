package lr11;

import java.util.List;

public class Task6 {
    public static List<Integer> divisibleBy(List<Integer> in, int divisor) {
        return in.stream().filter(x -> divisor != 0 && x % divisor == 0).toList();
    }

    public static void main(String[] args) {
        System.out.println(divisibleBy(List.of(3, 4, 6, 8, 9, 12), 3));
    }
}
