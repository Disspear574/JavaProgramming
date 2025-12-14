package lr4;

public class Task7 {
    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;
        int[][] array = new int[rows][cols];

        int value = 1;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                array[top][j] = value++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                array[i][right] = value++;
            }
            right--;

            for (int j = right; j >= left; j--) {
                array[bottom][j] = value++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                array[i][left] = value++;
            }
            left++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println();
        }
    }
}
