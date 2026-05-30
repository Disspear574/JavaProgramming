package lr10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Task4 {
    private static String readZipEntry(ZipFile zip, String entryName) throws Exception {
        ZipEntry entry = zip.getEntry(entryName);
        if (entry == null) return null;
        try (InputStream in = zip.getInputStream(entry)) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private static Document parseXml(String xml) throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
    }

    private static List<String> parseSharedStrings(String xml) throws Exception {
        List<String> strings = new ArrayList<>();
        if (xml == null) return strings;
        Document doc = parseXml(xml);
        NodeList si = doc.getElementsByTagName("si");
        for (int i = 0; i < si.getLength(); i++) {
            Element e = (Element) si.item(i);
            NodeList t = e.getElementsByTagName("t");
            strings.add(t.getLength() > 0 ? t.item(0).getTextContent() : "");
        }
        return strings;
    }

    private static Map<Integer, List<String>> parseSheetRows(String sheetXml, List<String> shared) throws Exception {
        Map<Integer, List<String>> rows = new TreeMap<>();
        Document doc = parseXml(sheetXml);
        NodeList rowNodes = doc.getElementsByTagName("row");
        for (int i = 0; i < rowNodes.getLength(); i++) {
            Element row = (Element) rowNodes.item(i);
            int rowNum = Integer.parseInt(row.getAttribute("r"));
            List<String> values = new ArrayList<>();

            NodeList cNodes = row.getElementsByTagName("c");
            for (int j = 0; j < cNodes.getLength(); j++) {
                Element c = (Element) cNodes.item(j);
                String type = c.getAttribute("t");
                NodeList vNodes = c.getElementsByTagName("v");
                String value = "";
                if (vNodes.getLength() > 0) {
                    String raw = vNodes.item(0).getTextContent();
                    if ("s".equals(type)) {
                        int idx = Integer.parseInt(raw);
                        value = (idx >= 0 && idx < shared.size()) ? shared.get(idx) : "";
                    } else {
                        value = raw;
                    }
                }
                values.add(value);
            }
            rows.put(rowNum, values);
        }
        return rows;
    }

    public static void main(String[] args) {
        Path xlsx = Path.of("lab10/data/sample.xlsx");
        try {
            if (!Files.exists(xlsx)) {
                System.out.println("Файл не найден: " + xlsx);
                System.out.println("Положите xlsx-файл в lab10/data и запустите снова.");
                return;
            }
            try (ZipFile zip = new ZipFile(xlsx.toFile())) {
                String sharedXml = readZipEntry(zip, "xl/sharedStrings.xml");
                String sheetXml = readZipEntry(zip, "xl/worksheets/sheet1.xml");
                if (sheetXml == null) throw new IllegalStateException("В файле нет листа sheet1.xml");

                List<String> shared = parseSharedStrings(sharedXml);
                Map<Integer, List<String>> rows = parseSheetRows(sheetXml, shared);

                System.out.println("Прочитано строк: " + rows.size());
                for (Map.Entry<Integer, List<String>> e : rows.entrySet()) {
                    System.out.println(e.getKey() + ": " + e.getValue());
                }
            }
        } catch (java.util.zip.ZipException e) {
            System.out.println("Неверный формат файла: ожидался корректный .xlsx (zip-архив OOXML). " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Структура файла нарушена: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка чтения Excel: " + e.getMessage());
        }
    }
}
