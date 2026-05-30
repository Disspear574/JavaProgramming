package lr11;

import java.util.List;

public class Task9 {
    public static List<String> onlyLetters(List<String> in) {
        return in.stream()
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(onlyLetters(List.of("Java", "C++", "Python3", "Kotlin")));
    }
}
