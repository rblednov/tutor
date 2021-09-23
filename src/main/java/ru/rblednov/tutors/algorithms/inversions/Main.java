package ru.rblednov.tutors.algorithms.inversions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static long a = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        LinkedList<ArrayList<Long>> arr = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Long> tmp = new ArrayList<>();
            tmp.add(s.nextLong());
            arr.add(tmp);
        }
        while (arr.size() >= 2) {
            ArrayList<Long> m1 = getAndRemoveFirst(arr);
            ArrayList<Long> m2 = getAndRemoveFirst(arr);
            if (m1.size() < m2.size()) {
                putToEnd(arr, m1);
                m1 = m2;
                m2 = getAndRemoveFirst(arr);
            }
            ArrayList<Long> m3 = merge(m1, m2);
            putToEnd(arr, m3);
        }
        System.out.println(arr.getFirst());
        System.out.println(a);
    }

    private static void putToEnd(LinkedList<ArrayList<Long>> arr, ArrayList<Long> m3) {
        arr.addLast(m3);
    }

    private static ArrayList<Long> merge(ArrayList<Long> m1, ArrayList<Long> m2) {
        if (m1.size() < m2.size()) {
            ArrayList<Long> tmp = m1;
            m1 = m2;
            m2 = tmp;
        }
        int m1_id = 0;
        int m2_id = 0;
        ArrayList<Long> result = new ArrayList<>(m1.size() + m2.size());
        for (int i = 0; i < m1.size() + m2.size(); i++) {
            if (m1_id > m1.size() - 1) {
                result.addAll(m2.subList(m2_id, m2.size()));
                break;
            }
            if (m2_id > m2.size() - 1) {
                result.addAll(m1.subList(m1_id, m1.size()));
                break;
            }
            long m1_on_id = m1.get(m1_id);
            long m2_on_id = m2.get(m2_id);
            if (m1_on_id <= m2_on_id) {
                result.add(m1_on_id);
                m1_id = m1_id + 1;
            } else {
                result.add(m2_on_id);
                m2_id = m2_id + 1;
                a = a + 1 * (m1.size() - m1_id);
            }
        }
        return result;
    }

    private static ArrayList<Long> getAndRemoveFirst(LinkedList<ArrayList<Long>> arr) {
        return arr.removeFirst();
    }
}
/*
* 6
10 8 6 2 4 5
answer is 12
----------
6
1 9 8 1 4 1
answer is 8
----------
6
6 5 8 6 0 4
answer is 10
----------
6
6 2 3 7 5 8
answer is 4
----------
6
6 4 5 0 0 2
answer is 11
----------
6
8 9 10 7 4 0
answer is 12
----------
6
10 9 3 8 3 10
answer is 8
----------
6
9 10 9 5 7 7
answer is 10
----------
6
9 5 8 9 4 10
answer is 6
----------
6
5 7 0 2 2 0
answer is 10
----------*/