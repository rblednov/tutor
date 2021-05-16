package ru.rblednov.tutors.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner s = new Scanner(System.in);
        int sizeMass = s.nextInt();
        int a[] = new int[sizeMass];
        for (int i = 0; i < sizeMass; i++) {
            a[i] = s.nextInt();
        }
        sizeMass = s.nextInt();
        int b[] = new int[sizeMass];
        for (int i = 0; i < sizeMass; i++) {
            b[i] = s.nextInt();
        }
        main.run(a, b);
    }

    private void run(int[] a, int[] b) {
        Arrays.sort(a);
        for (int i = 0; i < b.length; i++) {
            int currnet = b[i];
            int start = 0;
            int end = a.length - 1;
            int midle;
            while (true) {
                if (start > end) {
                    System.out.print("-1 ");
                    break;
                }
                midle = start + (end - start) / 2;
                if (a[midle] == currnet) {
                    System.out.print(midle + 1 + " ");
                    break;
                } else if (currnet < a[midle]) {
                    end = midle - 1;
                } else {
                    start = midle + 1;
                }
            }
        }
    }
}
