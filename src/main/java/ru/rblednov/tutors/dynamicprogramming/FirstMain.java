package ru.rblednov.tutors.dynamicprogramming;

import java.util.Scanner;

public class FirstMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n==1){
            System.out.println(1);
            return;
        }

        int A[] = new int[n];
        int D[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isDevide(A[j], A[i])) {
                    if (D[j] + 1 > D[i]) {
                        D[i] = D[j] + 1;
                    }
                }
            }
        }
        int maxD = 1;
        for (int i = 0; i < n; i++) {
            if(D[i]>maxD){
                maxD = D[i];
            }
        }
        System.out.println(maxD);
    }

    public static boolean isDevide(int a, int b) {
        return b % a == 0;
    }
}
