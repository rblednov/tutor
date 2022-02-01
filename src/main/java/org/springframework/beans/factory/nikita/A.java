package org.springframework.beans.factory.nikita;

public class A {
    public int localA = 0;
    public A(int a){
        this.localA=a;
    }
    public int a(int tmp){return localA+tmp;};
}
