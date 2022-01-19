package edu.upc.etsetb.arqsoft.spreadsheet;

import edu.upc.etsetb.arqsoft.spreadsheet.ui.UserInterface;

public class App {
    /*private static String getString(int n) {
        char[] buf = new char[(int) floor(log(25 * (n + 1)) / log(26))];
        for (int i = buf.length - 1; i >= 0; i--) {

            n--;
            buf[i] = (char) ('A' + n % 26);
            n /= 26;
        }
        return new String(buf);
    }

    private static int getIndex(String column) {
        int lAlfabeto = 26;
        char[] charr = column.toCharArray();
        int acc = 0;
        for (int i=0; i < charr.length; i++)  {
            int weight = (int) Math.pow(lAlfabeto, i);
            int mod = ((int)charr[charr.length - i - 1] - (int)'A'+1) % lAlfabeto;
            acc += weight * (mod);
        }
        return acc;
    }*/
    public static void main(String[] args) {
        System.out.println("Starting application ...");
        UserInterface ui = new UserInterface();
        ui.mainLoop();
        // 703 es AAA
        // Modulo es 26
    }
}
