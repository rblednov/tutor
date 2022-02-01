package org.springframework.beans.factory.nikita;

import static org.springframework.beans.factory.nikita.A;

public class B {
    public static void b(){};
    public B(){
        System.out.println("init B()");
    }
    public void bNonStatic(){
        int qwe = 123;
        qwe.a();
    }
}
