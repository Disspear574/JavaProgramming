package lr3;

public class Task8 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        char c = 'A';
        int i = 0;
        while (i < 10) {
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                arr[i] = c;
                i++;
            }
            c++;
        }
        for (char x : arr) System.out.print(x + " ");
    }
}