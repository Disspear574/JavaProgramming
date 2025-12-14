package lr4;

import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        Random random = new Random();

        int rows = 5;
        int cols = 5;
        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int removeRow = random.nextInt(rows);
        int removeCol = random.nextInt(cols);

        System.out.println("\nУдаляем строку: " + removeRow + ", столбец: " + removeCol);

        int[][] newArray = new int[rows - 1][cols - 1];

        int r = 0;
        for (int i = 0; i < rows; i++) {
            if (i == removeRow) continue;

            int c = 0;
            for (int j = 0; j < cols; j++) {
                if (j == removeCol) continue;

                newArray[r][c] = array[i][j];
                c++;
            }
            r++;
        }

        System.out.println("\nНовый массив:");
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[0].length; j++) {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
