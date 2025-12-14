package lr4;

public class Task4 {
    public static void main(String[] args) {
        int size = 6;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
