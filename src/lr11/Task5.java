package lr11;

import java.util.List;

public class Task5 {
    public static List<String> containsSub(List<String> in, String sub) {
        return in.stream().filter(s -> s.contains(sub)).toList();
    }

    public static void main(String[] args) {
        System.out.println(containsSub(List.of("stream", "api", "functional", "team"), "am"));
    }
}
