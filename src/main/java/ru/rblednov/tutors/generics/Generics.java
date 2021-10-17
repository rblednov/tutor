package ru.rblednov.tutors.generics;

import java.lang.reflect.InvocationTargetException;

public class Generics {
    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.pollLast());
        System.out.println(list.pollLast());
        System.out.println(list.pollLast());

    }
}
