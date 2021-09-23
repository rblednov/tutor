package ru.rblednov.tutors.algorithms.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int A[] = new int[n];
        int D[] = new int[n];
        int prev[] = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            prev[i] = -1;
        }

        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] >= A[i]) {
                    if (D[j] + 1 > D[i]) {
                        D[i] = D[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        int maxD = 1;
        int maxDi = 0;
        for (int i = 0; i < n; i++) {
            if (D[i] > maxD) {
                maxD = D[i];
                maxDi = i;
            }

        }
        List<Integer> list = new LinkedList<>();
        //увличиваем на 1 так как в задаче индекс начинаются с 1
        list.add(maxDi + 1);
        int pervI = maxDi;
        while (true) {
            pervI = prev[pervI];
            if (pervI == -1) {
                break;
            }
            //увличиваем на 1 так как в задаче индекс начинаются с 1
            list.add(pervI + 1);
        }
        System.out.println(maxD);
        String answer = "";
        for (Integer elem : list) {
            answer = elem + " " + answer;
        }
        System.out.println(answer);
    }
}
