package ru.rblednov.tutors.reflection;

import java.lang.reflect.InvocationTargetException;
import ru.rblednov.tutors.generics.Generics;

public class Reflect {


    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class classs = Generics.class.getClassLoader().loadClass("ru.rblednov.tutors.generics.LinkedList");
        Object list = classs.getDeclaredConstructors()[0].newInstance();


        System.out.println(list);
    }
}
