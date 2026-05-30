package lr10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private record Book(String title, String author, int year) {}

    private static Document loadOrCreate(String path) throws Exception {
        File file = new File(path);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        if (file.exists()) return builder.parse(file);

        Document doc = builder.newDocument();
        Element root = doc.createElement("books");
        doc.appendChild(root);
        addBook(doc, root, new Book("Война и мир", "Лев Толстой", 1869));
        addBook(doc, root, new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        save(doc, path);
        return doc;
    }

    private static void addBook(Document doc, Element root, Book b) {
        Element book = doc.createElement("book");
        Element title = doc.createElement("title");
        title.setTextContent(b.title());
        Element author = doc.createElement("author");
        author.setTextContent(b.author());
        Element year = doc.createElement("year");
        year.setTextContent(Integer.toString(b.year()));
        book.appendChild(title);
        book.appendChild(author);
        book.appendChild(year);
        root.appendChild(book);
    }

    private static List<Book> readBooks(Document doc) {
        List<Book> books = new ArrayList<>();
        NodeList nodes = doc.getElementsByTagName("book");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element e = (Element) nodes.item(i);
            String title = e.getElementsByTagName("title").item(0).getTextContent();
            String author = e.getElementsByTagName("author").item(0).getTextContent();
            int year = Integer.parseInt(e.getElementsByTagName("year").item(0).getTextContent());
            books.add(new Book(title, author, year));
        }
        return books;
    }

    private static List<Book> findByAuthorOrYear(List<Book> books, String author, int year) {
        List<Book> out = new ArrayList<>();
        for (Book b : books) {
            if (b.author().equalsIgnoreCase(author) || b.year() == year) out.add(b);
        }
        return out;
    }

    private static boolean removeByTitle(Document doc, String title) {
        NodeList nodes = doc.getElementsByTagName("book");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element e = (Element) nodes.item(i);
            String t = e.getElementsByTagName("title").item(0).getTextContent();
            if (t.equalsIgnoreCase(title)) {
                e.getParentNode().removeChild(e);
                return true;
            }
        }
        return false;
    }

    private static void save(Document doc, String path) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(doc), new StreamResult(new File(path)));
    }

    public static void main(String[] args) {
        String path = "lab10/data/books.xml";
        Scanner sc = new Scanner(System.in);
        try {
            Document doc = loadOrCreate(path);
            Element root = doc.getDocumentElement();

            boolean running = true;
            while (running) {
                System.out.println("\n1 - добавить книгу");
                System.out.println("2 - поиск по автору или году");
                System.out.println("3 - удалить книгу по названию");
                System.out.println("4 - показать все книги");
                System.out.println("0 - выход с сохранением");
                System.out.print("Выбор: ");
                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1" -> {
                        System.out.print("Название: ");
                        String title = sc.nextLine().trim();
                        System.out.print("Автор: ");
                        String author = sc.nextLine().trim();
                        System.out.print("Год: ");
                        int year = Integer.parseInt(sc.nextLine().trim());
                        addBook(doc, root, new Book(title, author, year));
                        System.out.println("Книга добавлена");
                    }
                    case "2" -> {
                        System.out.print("Автор (пусто - пропустить): ");
                        String author = sc.nextLine().trim();
                        System.out.print("Год (пусто - пропустить): ");
                        String yearStr = sc.nextLine().trim();
                        int year = yearStr.isEmpty() ? -1 : Integer.parseInt(yearStr);
                        List<Book> found = findByAuthorOrYear(readBooks(doc), author, year);
                        System.out.println("Найдено: " + found.size());
                        for (Book b : found) System.out.println(b);
                    }
                    case "3" -> {
                        System.out.print("Название для удаления: ");
                        String title = sc.nextLine().trim();
                        System.out.println("Удаление: " + removeByTitle(doc, title));
                    }
                    case "4" -> {
                        List<Book> all = readBooks(doc);
                        System.out.println("Всего книг: " + all.size());
                        for (Book b : all) System.out.println(b);
                    }
                    case "0" -> running = false;
                    default -> System.out.println("Неизвестная команда");
                }
            }

            save(doc, path);
            System.out.println("XML сохранен: " + path);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: год должен быть числом");
        } catch (Exception e) {
            System.out.println("Ошибка XML: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
