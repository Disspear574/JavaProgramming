package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    // Среднее среди положительных элементов int[]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            if (n <= 0) throw new IllegalArgumentException("Размер массива должен быть > 0");

            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x > 0) {
                    sum = Math.addExact(sum, x);
                    count++;
                }
            }
            if (count == 0) throw new IllegalStateException("Положительные элементы отсутствуют");
            System.out.println("avg = " + (sum / (double) count));
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: переполнение типа int при суммировании положительных элементов");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Обработка завершена");
        }
    }
}
