package ru.rblednov.tutors.algorithms.dynamicprogramming.last;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] D = new int[n + 1];
        int[] prevNArr = new int[n + 1];
        D[0] = 0;
        for (int i = 2; i <= n; i++) {
            D[i] = Integer.MAX_VALUE;
            int d3 = i % 3 == 0 ? i / 3 : -1;
            int d2 = i % 2 == 0 ? i / 2 : -1;
            int m1 = i - 1;
            int prevN = 0;
            if (d3 != -1 && D[d3] < D[i]) {
                D[i] = D[d3] + 1;
                prevN = d3;
            }
            if (d2 != -1 && D[d2] < D[i]) {
                D[i] = D[d2] + 1;
                prevN = d2;
            }
            if (D[m1] < D[i]) {
                D[i] = D[m1] + 1;
                prevN = m1;
            }
            prevNArr[i] = prevN;
        }
        System.out.println(D[n]);

        LinkedList<Integer> ansArr = new LinkedList<Integer>();
        ansArr.add(n);
        int copyN = n;
        while (copyN != 1) {
            copyN = prevNArr[copyN];
            ansArr.add(copyN);
        }
        for (int i = 0;i<=D[n];i++){
            System.out.print(ansArr.getLast()+" ");
            ansArr.removeLast();
        }
    }
}
