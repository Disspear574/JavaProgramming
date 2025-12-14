package lr4;

public class Task3 {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 10;

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = 2;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
