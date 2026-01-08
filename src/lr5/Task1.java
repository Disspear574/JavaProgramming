package lr5;

import core.Logger;

import java.util.Scanner;

public class Task1 {

    private static class CharHolder {
        private char ch;

        public void setChar(char c) {
            ch = c;
        }

        public int getCode() {
            return (int) ch;
        }

        public void printCharAndCode() {
            Logger.log("Symbol:" + " " + ch);
            Logger.log("Code:" + " " + getCode());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = s.charAt(0);

        CharHolder holder = new CharHolder();
        holder.setChar(c);
        holder.printCharAndCode();
    }
}
