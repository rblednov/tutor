package ru.rblednov.tutors;

import java.util.ArrayList;
import java.util.Optional;

class Main {
    class A {
        public String lol(Integer a) {
            Integer b = 3;
            Optional.of(b)
                    .map(B::makeDoubleAndString);

            return String.valueOf(a * 2);
        }
    }

    class B {
        public String makeDoubleAndString(Integer a) {
            return String.valueOf(a * 2);
        }
    }

    public static void main(String[] args) {


    }
}