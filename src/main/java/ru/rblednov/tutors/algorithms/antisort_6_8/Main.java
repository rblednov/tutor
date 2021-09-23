package ru.rblednov.tutors.algorithms.antisort_6_8;

import java.util.Scanner;
/*
Первая строка содержит число 1 \le n \le 10^41≤n≤10
4 , вторая — nn натуральных чисел, не превышающих 10. Выведите упорядоченную по неубыванию последовательность этих чисел.
* */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int colvo = s.nextInt();
        int result[] = new int[11];
        for (int i = 1; i <= 10; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < colvo; i++) {
            int tmp = s.nextInt();
            result[tmp]++;
        }
        for (int i = 1; i <= 10; i++) {
            int tmp = result[i];
            for(int j = 0;j<tmp;j++){
                System.out.print(i+" ");
            }
        }
    }
}
