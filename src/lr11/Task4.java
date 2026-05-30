package lr11;

import java.util.List;

public class Task4 {
    public static List<Integer> squares(List<Integer> in) {
        return in.stream().map(x -> x * x).toList();
    }

    public static void main(String[] args) {
        System.out.println(squares(List.of(1, 2, 3, 4)));
    }
}
