package lr10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    private record Book(String title, String author, int year) {}

    private static final Pattern BOOK_PATTERN = Pattern.compile(
            "\\{\\s*\"title\"\\s*:\\s*\"([^\"]+)\"\\s*,\\s*\"author\"\\s*:\\s*\"([^\"]+)\"\\s*,\\s*\"year\"\\s*:\\s*(\\d+)\\s*\\}");

    private static List<Book> parseBooks(String json) {
        List<Book> books = new ArrayList<>();
        Matcher m = BOOK_PATTERN.matcher(json);
        while (m.find()) {
            books.add(new Book(m.group(1), m.group(2), Integer.parseInt(m.group(3))));
        }
        return books;
    }

    private static String toJson(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n  \"books\": [\n");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            sb.append("    {\"title\": \"").append(b.title())
                    .append("\", \"author\": \"").append(b.author())
                    .append("\", \"year\": ").append(b.year()).append("}");
            if (i + 1 < books.size()) sb.append(",");
            sb.append("\n");
        }
        sb.append("  ]\n}");
        return sb.toString();
    }

    private static void ensureFile(Path path) throws IOException {
        if (Files.exists(path)) return;
        List<Book> sample = List.of(
                new Book("Война и мир", "Лев Толстой", 1869),
                new Book("Герой нашего времени", "Михаил Лермонтов", 1840)
        );
        Files.createDirectories(path.getParent());
        Files.writeString(path, toJson(sample), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        Path path = Path.of("lab10/data/books.json");
        Scanner sc = new Scanner(System.in);
        try {
            ensureFile(path);
            String json = Files.readString(path, StandardCharsets.UTF_8);
            List<Book> books = new ArrayList<>(parseBooks(json));

            boolean running = true;
            while (running) {
                System.out.println("\n1 - поиск по автору");
                System.out.println("2 - добавить книгу");
                System.out.println("3 - удалить книгу по названию");
                System.out.println("4 - показать все книги");
                System.out.println("0 - выход с сохранением");
                System.out.print("Выбор: ");
                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1" -> {
                        System.out.print("Автор: ");
                        String author = sc.nextLine().trim();
                        int found = 0;
                        for (Book b : books) {
                            if (b.author().equalsIgnoreCase(author)) {
                                System.out.println(b);
                                found++;
                            }
                        }
                        System.out.println("Найдено: " + found);
                    }
                    case "2" -> {
                        System.out.print("Название: ");
                        String title = sc.nextLine().trim();
                        System.out.print("Автор: ");
                        String author = sc.nextLine().trim();
                        System.out.print("Год: ");
                        int year = Integer.parseInt(sc.nextLine().trim());
                        books.add(new Book(title, author, year));
                        System.out.println("Книга добавлена");
                    }
                    case "3" -> {
                        System.out.print("Название для удаления: ");
                        String title = sc.nextLine().trim();
                        boolean removed = books.removeIf(b -> b.title().equalsIgnoreCase(title));
                        System.out.println("Удаление: " + removed);
                    }
                    case "4" -> {
                        System.out.println("Всего книг: " + books.size());
                        for (Book b : books) System.out.println(b);
                    }
                    case "0" -> running = false;
                    default -> System.out.println("Неизвестная команда");
                }
            }

            Files.writeString(path, toJson(books), StandardCharsets.UTF_8);
            System.out.println("JSON сохранен: " + path);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: год должен быть числом");
        } catch (IOException e) {
            System.out.println("Ошибка JSON: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
