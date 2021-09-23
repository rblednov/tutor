package ru.rblednov.tutors.javatutors;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class FIndeMinMax {
    public static void main(String[] args) {

    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        T max;
//        stream.sorted(order).;
        // your implementation here
    }
}
