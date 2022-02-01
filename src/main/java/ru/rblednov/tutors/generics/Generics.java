package ru.rblednov.tutors.generics;

import java.lang.reflect.InvocationTargetException;

public class Generics {
    public static void main(String[] args){
//            throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        LinkedList<String> list = new LinkedList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
////        System.out.println(list.pollLast());
////        System.out.println(list.pollLast());
////        System.out.println(list.pollLast());
//
//        var a = list.getAll(x->x.equals("b"));
//        System.err.println(a);

        Float f1 = -0f;
        Float f2 = +0f;
        float f3 = -0f;
        float f4 = +0f;
        System.err.println(f1.equals(f2));
        System.err.println(-0f==+0f);
        System.err.println(f3==f4);
    }
}
