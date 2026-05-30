package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {
    // Сумма элементов byte-массива с контролем диапазона
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            if (n <= 0) throw new IllegalArgumentException("Размер массива должен быть > 0");
            byte[] a = new byte[n];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val < Byte.MIN_VALUE || val > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Значение вне диапазона byte: " + val);
                }
                a[i] = (byte) val;
            }

            int sum = 0;
            for (byte x : a) {
                sum += x;
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Переполнение диапазона byte при суммировании");
                }
            }
            System.out.println("sum = " + sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Обработка завершена");
        }
    }
}
