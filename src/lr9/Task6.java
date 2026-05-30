package lr9;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Task6 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "кот");
        map.put(1, "яблоко");
        map.put(2, "машина");
        map.put(3, "стол");
        map.put(4, "ноутбук");
        map.put(5, "река");
        map.put(6, "программа");
        map.put(7, "алгоритм");
        map.put(8, "список");
        map.put(9, "коллекция");

        System.out.println("Строки, где ключ > 5:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() > 5) {
                System.out.println(e.getKey() + " -> " + e.getValue());
            }
        }

        StringJoiner joiner = new StringJoiner(", ");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() == 0) {
                joiner.add(e.getValue());
            }
        }
        System.out.println("Строки при ключе = 0: " + joiner);

        long product = 1;
        boolean hasAny = false;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getValue() != null && e.getValue().length() > 5) {
                product *= e.getKey();
                hasAny = true;
            }
        }
        System.out.println("Произведение ключей, где длина строки > 5: " + (hasAny ? product : "нет таких"));
    }
}
