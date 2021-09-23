package ru.rblednov.tutors.javatutors;

import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsTutors {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        Integer a = s.nextInt();
//        Integer b = s.nextInt();
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        IntUnaryOperator iuo = x ->{
            return x*x/10%1000;
        };
        IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return 0;
            }
        };

        return IntStream.iterate(seed, iuo);
    }

}
