package ru.rblednov.tutors.algorithms.dynamicprogramming.editdist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String wordA = s.nextLine();
        String wordB = s.nextLine();

        // динамика
        int iMax = wordA.length();
        int jMax = wordB.length();
        int[][] D = new int[iMax + 1][jMax + 1];

        //initialise
        D[0][0] = 0;
        for (int i = 0; i <= iMax; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j <= jMax; j++) {
            D[0][j] = j;
        }

        //BottomUp
        for (int i = 1; i <= iMax; i++) {
            for (int j = 1; j <= jMax; j++) {
                D[i][j] = min3(
                        D[i - 1][j] + 1,
                        D[i][j - 1] + 1,
                        D[i - 1][j - 1] + diff(wordA.charAt(i-1), wordB.charAt(j-1)));
            }
        }
        //Breakpoint
//        System.err.println("Breakpoint");
        System.out.println(D[iMax][jMax]);
    }

    private static int diff(char first, char second) {
        return first == second ? 0 : 1;
    }

    private static int min3(int i, int i1, int i2) {
        if (i <= i1 && i <= i2) {
            return i;
        }
        if (i1 <= i && i1 <= i2) {
            return i1;
        }
        return i2;
    }
}
