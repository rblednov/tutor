package ru.rblednov.tutors;

import java.util.Scanner;

public class TutorMaxDifferentParts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n <= 2) {
            System.out.println(1);
            System.out.println(n);
            return;
        }

        double presum = 0.0;
        double sum = 0.0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            if (n >= sum && n < sum + i + 1) {
                stringBuilder.append((int)(i + n - sum));
                System.out.println(i);
                System.out.println(stringBuilder);
                return;
            }
            stringBuilder.append(i).append(" ");
        }

    }
}
