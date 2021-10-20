package ru.rblednov.tutors.algorithms.dynamicprogramming.lader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int laderSteps = s.nextInt();
        int[] stepsVal = new int[laderSteps + 1];
        for (int i = 1; i <= laderSteps; i++) {
            stepsVal[i] = s.nextInt();
        }
        int D[] = new int[laderSteps+1];
        D[0] = 0;
        D[1] = stepsVal[1];
        for(int i = 2;i<=laderSteps;i++){
            D[i] = max2(D[i-1]+stepsVal[i],D[i-2]+stepsVal[i]);
        }
        System.out.println(D[laderSteps]);
    }

    private static int max2(int v, int i) {
        return Math.max(v, i);
    }
}
