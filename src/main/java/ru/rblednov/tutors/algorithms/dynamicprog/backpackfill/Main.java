package ru.rblednov.tutors.algorithms.dynamicprog.backpackfill;

import java.util.Scanner;

public class Main {
    public static int[] weight;
    public static int n;

    public static void main(String[] args) {
        //read input
        Scanner s = new Scanner(System.in);
        int W = s.nextInt();
        n = s.nextInt();
        weight = new int[n+1];
        for (int i = 1; i <= n; i++) {
            weight[i] = s.nextInt();
        }

        //instantinate
        int[][] D = new int[W+1][n+1];
        for (int i = 0; i <= W; i++) {
            D[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            D[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                D[w][i] = D[w][i - 1];
                if (weight[i] <= w) {
                    D[w][i] = max2(D[w][i], D[w - weight[i]][i - 1] + weight[i]);
                }
            }
        }
        //Brakepoint
//        System.err.println("Brakepoint");
        System.out.println(D[W][n]);
    }


    private static int max2(int v, int i) {
        return Math.max(v, i);
    }
}
