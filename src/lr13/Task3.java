package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    // Вывод столбца матрицы по номеру
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("Размеры матрицы должны быть > 0");

            int[][] m = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) m[i][j] = sc.nextInt();
            }

            int columnIndex = sc.nextInt();
            if (columnIndex < 0 || columnIndex >= cols) throw new IndexOutOfBoundsException("Нет столбца с таким номером");

            for (int i = 0; i < rows; i++) System.out.println(m[i][columnIndex]);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Обработка завершена");
        }
    }
}
