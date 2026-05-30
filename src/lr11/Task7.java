package lr11;

import java.util.List;

public class Task7 {
    public static List<String> longerThan(List<String> in, int len) {
        return in.stream().filter(s -> s.length() > len).toList();
    }

    public static void main(String[] args) {
        System.out.println(longerThan(List.of("cat", "elephant", "dog", "tiger"), 3));
    }
}
