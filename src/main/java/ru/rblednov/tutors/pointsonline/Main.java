package ru.rblednov.tutors.pointsonline;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    class Point {
        int x;
        char type;

        public Point(int x, char type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public String toString() {
            return "x=" + x + ", " + "type=" + type;
        }
    }

    class XPoint extends Point implements Comparable<XPoint> {
        int orderNumber;
        int count = 0;

        public XPoint(int x, char type, int orderNumber) {
            super(x, type);
            this.orderNumber = orderNumber;
        }

        @Override
        public int compareTo(XPoint o) {
            return Integer.compare(this.orderNumber, o.orderNumber);
        }
    }

    private void run() {

        long start_time = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        int nSize = Integer.parseInt(s.next());
        int mSize = Integer.parseInt(s.next());

        Point[] points = new Point[nSize + nSize + mSize];
        for (int i = 0; i < nSize + nSize; i = i + 2) {
            points[i] = new Point(Integer.parseInt(s.next()), 's');
            points[i + 1] = new Point(Integer.parseInt(s.next()), 'e');
        }
        for (int i = nSize + nSize; i < nSize + nSize + mSize; i++) {
            points[i] = new XPoint(Integer.parseInt(s.next()), 'p', i);
        }

        long after_read = System.currentTimeMillis();
//        Arrays.sort(points, Comparator.comparingInt(p->p.x));
        qSort_3(points, 0, nSize + nSize + mSize - 1);
        long after_sort = System.currentTimeMillis();

        findeMatches_1(points);
        long after_all = System.currentTimeMillis();

//
//        System.err.println("read = " + (after_read - start_time));
//        System.err.println("sort = " + (after_sort - after_read));
//        System.err.println("find points = " + (after_all - after_sort));
//        System.err.println("all = " + (after_all - start_time));
    }

    private void findeMatches_1(Point[] points) {
        int current_x = points[0].x;
        int countStarts = 0;
        int countEnds = 0;

        TreeSet<XPoint> resultPointsAccumulator = new TreeSet<>();
        LinkedList<XPoint> localPointsAccumulator = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            Point newPoint = points[i];
            if (newPoint.x != current_x) {
                current_x = newPoint.x;
                final int finalCountStarts = countStarts;
                localPointsAccumulator.forEach(point -> point.count = finalCountStarts);
                resultPointsAccumulator.addAll(localPointsAccumulator);
                countStarts = countStarts - countEnds;
                countEnds = 0;
                localPointsAccumulator.clear();
            }
            if (newPoint.type == 's') {
                countStarts = countStarts + 1;
            } else if (newPoint.type == 'e') {
                countEnds = countEnds + 1;
            } else if (newPoint.type == 'p') {
                localPointsAccumulator.add((XPoint) newPoint);
            }
        }
        final int finalCountStarts = countStarts;
        localPointsAccumulator.forEach(point -> point.count = finalCountStarts);
        resultPointsAccumulator.addAll(localPointsAccumulator);
        resultPointsAccumulator.forEach(xPoint -> System.out.print(xPoint.count + " "));
    }

    //
    private static void qSort(Point[] array, int start_id, int end_id) {
        if (end_id - start_id + 1 == 2) {
            if (array[start_id].x > array[end_id].x) {
                Point tmp = array[start_id];
                array[start_id] = array[end_id];
                array[end_id] = tmp;
            }
            return;
        }
        if (end_id - start_id + 1 <= 1) {
            return;
        }

        int random_id = getRandomVal(start_id, end_id);
        int last_low_id = start_id;

        Point random_val = array[random_id];
        array[random_id] = array[start_id];
        array[start_id] = random_val;
        for (int i = start_id + 1; i <= end_id; i++) {
            Point current = array[i];
            if (current.x > random_val.x) {
                //do nothing
            } else {
                array[i] = array[last_low_id + 1];
                array[last_low_id + 1] = current;
                last_low_id = last_low_id + 1;
            }
        }
        Point tmp = array[start_id];
        array[start_id] = array[last_low_id];
        array[last_low_id] = tmp;
        qSort(array, start_id, last_low_id - 1);
        qSort(array, last_low_id + 1, end_id);
    }

    private static void qSort_3(Point[] array, int p_start_id, int p_end_id) {
        if (p_end_id - p_start_id + 1 == 2) {
            if (array[p_start_id].x > array[p_end_id].x) {
                switchTwoVals(array, p_start_id, p_end_id);
            }
            return;
        }
        if (p_end_id - p_start_id + 1 <= 1) {
            return;
        }

        int random_id = getRandomVal(p_start_id, p_end_id);


        Point random_val = array[random_id];

        switchTwoVals(array, random_id, p_start_id);
        int p_first_big_id = p_start_id + 1;
        int p_first_eq_id = p_start_id + 1;
        for (int i = p_start_id + 1; i <= p_end_id; i++) {
            int current_id = i;
            Point current = array[current_id];
            if (current.x > random_val.x) {
                //do nothing
            } else if (current.x < random_val.x) {
                switchTwoVals(array, p_first_big_id, current_id);
                switchTwoVals(array, p_first_eq_id, p_first_big_id);
                ++p_first_big_id;
                ++p_first_eq_id;
            } else {
                switchTwoVals(array, p_first_big_id, current_id);
                ++p_first_big_id;
            }
        }

        int p_last_low_id;
        if (p_first_eq_id == p_start_id) {
            p_last_low_id = p_first_eq_id;
        } else {
            p_last_low_id = p_first_eq_id - 1;
            switchTwoVals(array, p_last_low_id, p_start_id);
            --p_last_low_id;
        }

        qSort_3(array, p_start_id, p_last_low_id);
        qSort_3(array, p_first_big_id, p_end_id);
    }

    private static void qSort_3_elimination(Point[] array, int p_start_id, int p_end_id) {
        while (p_end_id > p_start_id) {
//            if (p_end_id - p_start_id + 1 == 2) {
//                if (array[p_start_id].x > array[p_end_id].x) {
//                    switchTwoVals(array, p_start_id, p_end_id);
//                }
//                return;
//            }
            if (p_end_id - p_start_id + 1 <= 1) {
                return;
            }

            int random_id = getRandomVal(p_start_id, p_end_id);


            Point random_val = array[random_id];

            switchTwoVals(array, random_id, p_start_id);
            int p_first_big_id = p_start_id + 1;
            int p_first_eq_id = p_start_id + 1;
            int p_first_eq_point_id = p_start_id + 1;
            for (int i = p_start_id + 1; i <= p_end_id; i++) {
                int current_id = i;
                Point current = array[current_id];
                if (current.x < random_val.x) {
                    switchTwoVals(array, p_first_big_id, current_id);
                    switchTwoVals(array, p_first_eq_point_id, p_first_big_id);
                    switchTwoVals(array, p_first_eq_id, p_first_eq_point_id);
                    ++p_first_big_id;
                    ++p_first_eq_id;
                    ++p_first_eq_point_id;
                } else if (current.x == random_val.x && current.type == 'p') {
                    switchTwoVals(array, p_first_big_id, current_id);
                    ++p_first_big_id;
                } else if (current.x == random_val.x && current.type != 'p') {
                    switchTwoVals(array, p_first_big_id, current_id);
                    switchTwoVals(array, p_first_eq_point_id, p_first_big_id);
                    ++p_first_big_id;
                    ++p_first_eq_point_id;
                }
            }
            int p_last_low_id;
            if (p_first_eq_id == p_start_id) {
                p_last_low_id = p_first_eq_id;
            } else {
                p_last_low_id = p_first_eq_id - 1;
                if (array[p_last_low_id].type != 'p') {
                    switchTwoVals(array, p_last_low_id, p_start_id);
                } else {
                    switchTwoVals(array, p_last_low_id, p_start_id);
                    if (p_first_eq_point_id != p_last_low_id) {
                        int p_last_eq_not_point_id = p_first_eq_point_id - 1;
                        switchTwoVals(array, p_last_eq_not_point_id, p_last_low_id);
                    }
                }
                --p_last_low_id;
            }

            qSort_3_elimination(array, p_start_id, p_last_low_id);
            p_start_id = p_first_big_id;
        }
    }

    private static void switchTwoVals(Object[] array, int id_1, int id_2) {
        if (id_1 == id_2) {
            return;
        }
        Object id_1_value = array[id_1];
        array[id_1] = array[id_2];
        array[id_2] = id_1_value;
    }

    private static int getRandomVal(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }
}

