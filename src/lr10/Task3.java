package lr10;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    private static final Pattern TITLE_PATTERN =
            Pattern.compile("<h[1-3][^>]*>(.*?)</h[1-3]>|<title[^>]*>(.*?)</title>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    private static String fetchWithRetry(String url, int attempts) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        Exception last = null;
        for (int i = 1; i <= attempts; i++) {
            try {
                HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                        .timeout(Duration.ofSeconds(10))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() >= 200 && response.statusCode() < 300) return response.body();
                throw new IOException("HTTP status " + response.statusCode());
            } catch (Exception e) {
                last = e;
                System.out.println("Попытка " + i + " не удалась: " + e.getMessage());
                Thread.sleep(500L * i);
            }
        }
        throw last;
    }

    private static List<String> extractTitles(String html) {
        List<String> titles = new ArrayList<>();
        Matcher m = TITLE_PATTERN.matcher(html);
        while (m.find()) {
            String raw = m.group(1) != null ? m.group(1) : m.group(2);
            if (raw == null) continue;
            String cleaned = raw.replaceAll("<[^>]+>", " ").replaceAll("\\s+", " ").trim();
            if (!cleaned.isEmpty()) titles.add(cleaned);
        }
        return titles;
    }

    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        Path out = Path.of("lab10/data/news_titles.txt");
        try {
            Files.createDirectories(out.getParent());
            String html = fetchWithRetry(url, 3);
            List<String> titles = extractTitles(html);

            List<String> lines = new ArrayList<>();
            lines.add("Источник: " + url);
            lines.add("Найдено заголовков: " + titles.size());
            lines.add("");
            for (int i = 0; i < titles.size(); i++) lines.add((i + 1) + ". " + titles.get(i));

            Files.write(out, lines, StandardCharsets.UTF_8);
            System.out.println("Сохранено в файл: " + out);
        } catch (Exception e) {
            System.out.println("Ошибка HTML-парсера: " + e.getMessage());
        }
    }
}
