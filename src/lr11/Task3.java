package lr11;

import java.util.List;

public class Task3 {
    public static List<String> startsWithUpper(List<String> in) {
        return in.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .toList();
    }

    public static void main(String[] args) {
        List<String> data = List.of("java", "Kotlin", "python", "Scala");
        System.out.println(startsWithUpper(data));
    }
}
