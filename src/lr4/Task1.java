package lr4;

import core.Logger;

public class Task1 {
    public static void main(String[] args) {
        int figure = 10;
        int i;
        int j;
        int z;

        for (i = 1; i <= figure; i++) {
            Logger.log("Номер строки:" + " "  + i + " ");
            z = 0;

            for (j = -5; j < figure; j++) {
                Logger.log("+");
                z = z + 1;
            }
            Logger.log("Количество символов в строке" + " " + z);
        }
    }
}
