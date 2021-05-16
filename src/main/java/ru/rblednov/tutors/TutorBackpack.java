package ru.rblednov.tutors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TutorBackpack {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int amount = s.nextInt();
        int bpVolume = s.nextInt();
        double result = 0F;
        float[][] showcase = new float[amount][2];
        for (int i = 0; i < amount; i++) {
            int price = s.nextInt();
            int volume = s.nextInt();
            showcase[i][0] = (float) volume;
            showcase[i][1] = (-1) * ((float) price / (float) volume);
        }
        Arrays.sort(showcase, Comparator.comparingDouble(x -> x[1]));

        for (int i = 0; i < amount; i++) {
            showcase[i][1] = -showcase[i][1];
            if (bpVolume <= showcase[i][0]) {
                result = result + ((float) bpVolume) * showcase[i][1];
                break;
            } else {
                bpVolume = bpVolume - (int) showcase[i][0];
                result = result + showcase[i][0] * showcase[i][1];
            }
        }
        System.out.println(String.format("%.3f", result));
    }
}
