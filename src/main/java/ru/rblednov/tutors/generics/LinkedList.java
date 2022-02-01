package ru.rblednov.tutors.generics;

import java.util.List;
import java.util.function.Predicate;

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
        } else {
            Node<T> node = new Node<T>();
            node.value = t;
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public T pollLast() {
        T value = tail.value;
        if (tail.prev != null) {
            tail.prev.next = null;
        }
        tail = tail.prev;
        return value;
    }

    public LinkedList<T> getAll(Predicate<? super T> p) {
        Node<T> current = head;
        LinkedList<T> currentList = new LinkedList<>();
        while (hasNext(current)) {
            if (p.test(current.value)) {
                currentList.add(current.value);
            }
            current = current.next;
        }
        return currentList;
    }

    private boolean hasNext(Node<T> current) {

        return current != null && current.next != null;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder str = new StringBuilder("[");
        do {
            str.append(current.value.toString());
            if (hasNext(current)) {
                str.append(";");
            }
            current = current.next;

        } while (hasNext(current));
        str.append("]");
        return str.toString();
    }
}
