package ru.rblednov.tutors.generics;

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;
    }

    public void add(T t) {
        if (head == null) {
            head = new Node<T>();
            tail = head;
            head.value = t;
        }else {
            Node<T> node = new Node<T>();
            node.value=t;
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public T pollLast(){
        T value = tail.value;
        tail.prev.next=null;
        tail = tail.prev;
        return value;
    }
}
