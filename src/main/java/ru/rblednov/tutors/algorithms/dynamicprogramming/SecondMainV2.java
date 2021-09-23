package ru.rblednov.tutors.algorithms.dynamicprogramming;

import java.util.Scanner;

public class SecondMainV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int A[] = new int[n];
        int D[] = new int[n + 1];
        int p[] = new int[n + 1];
        int prev[] = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            prev[i] = -1;
            D[i] = -1;
            p[i] = -1;
        }
        //инициализация Динамики D
        D[0] = Integer.MAX_VALUE;
        D[n] = -1;
        p[n] = -1;
        //ленивый выход
        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        }

        int lastElemId = 0;
        for (int i = 0; i < n; i++) {
            int leftElemId = bynarySrch(0, lastElemId, D, A[i]);
            D[leftElemId + 1] = A[i];
            p[leftElemId + 1] = i;
            prev[i] = p[leftElemId];
            if (leftElemId + 1 > lastElemId) {
                ++lastElemId;
            }
        }
        int maxDi = lastElemId;

        System.out.println(maxDi);
        StringBuilder answerStr = new StringBuilder();
        int idOfLastElem = p[maxDi];
        while (idOfLastElem != -1) {
            //увеличиваем так-как индексы в задаче с 1
            answerStr.insert(0, (idOfLastElem + 1) + " ");
            idOfLastElem = prev[idOfLastElem];
        }
        System.out.println(answerStr);
    }

    /**
     * returns left id of position
     *
     * @param l left id of array
     * @param r right id of array
     * @param d array
     */
    private static int bynarySrch(int l, int r, int[] d, int ai) {
        if (ai > d[0]) {
            return -1;
        }
        if (d[r] >= ai) {
            return r;
        }
        while (l != r - 1) {
            int m = (l + r) / 2;
            if (ai > d[m]) {
                r = m-1;
            } else if (d[m] >= ai) {
                l = m;
            }
        }
        return l;
    }
}
