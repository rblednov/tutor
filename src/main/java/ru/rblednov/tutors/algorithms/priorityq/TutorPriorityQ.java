package ru.rblednov.tutors.algorithms.priorityq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TutorPriorityQ {
    public class Operation {
        int insertVal = 0;

        boolean isExtractMax = false;
        boolean isInsert = false;


    }

    class PQueue {
        List<Integer> queue = new ArrayList<Integer>();

        void insert(Integer value) {
            queue.add(value);
            if (queue.size() == 2) {
                return;
            }
            siftUp();
        }

        private void siftUp() {
            int last_id = queue.size() - 1;
            int parent_id = last_id / 2;
            while (true) {
                if (parent_id == 1) {
                    if (queue.get(parent_id) < queue.get(last_id)) {
                        int parrent = queue.get(parent_id);
                        queue.set(parent_id, queue.get(last_id));
                        queue.set(last_id, parrent);
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (queue.get(parent_id) < queue.get(last_id)) {
                        int tmp = queue.get(parent_id);
                        queue.set(parent_id, queue.get(last_id));
                        queue.set(last_id, tmp);
                    } else {
                        return;
                    }
                }
                last_id = parent_id;
                parent_id = last_id / 2;
            }
        }

        Integer extractMax() {
            if (queue.size() == 1) {
                System.err.println("empty queue");
                return -1;
            }
            Integer max = queue.get(1);
            if (queue.size() == 2) {
                queue.remove(1);
                return max;
            }
            int last_id = queue.size() - 1;
            queue.set(1, queue.get(last_id));
            queue.remove(last_id);
            swiftDown();
            return max;
        }

        private void swiftDown() {
            int parrent_id = 1;

            while (true) {
                int children1_id = parrent_id * 2;
                int children2_id = parrent_id * 2 + 1;
                if (children1_id > queue.size() - 1) {
                    return;
                }
                if (children2_id > queue.size() - 1) {
                    int parrent = queue.get(parrent_id);
                    int children1 = queue.get(children1_id);
                    if (parrent <= children1) {
                        queue.set(parrent_id, children1);
                        queue.set(children1_id, parrent);
                    }
                    return;
                }else{
                    int parrent = queue.get(parrent_id);
                    int children1 = queue.get(children1_id);
                    int children2 = queue.get(children2_id);

                    if (parrent >= children1 && parrent >= children2) {
                        return;
                    }
                    if (children1 >= children2) {
                        queue.set(parrent_id, children1);
                        queue.set(children1_id, parrent);
                        parrent_id = children1_id;
                    }else {
                        queue.set(parrent_id, children2);
                        queue.set(children2_id, parrent);
                        parrent_id = children2_id;
                    }
                }
            }
        }
    }

    public Operation build(String operation) {
        Operation oper = new Operation();
        String[] tmp = operation.split(" ");
        if ("ExtractMax".equals(tmp[0])) {
            oper.isExtractMax = true;
            oper.isInsert = false;
        } else {
            oper.isExtractMax = false;
            oper.isInsert = true;
            oper.insertVal = Integer.parseInt(tmp[1]);
        }
        return oper;
    }

    public static void main(String[] args) {
        TutorPriorityQ tutorPriorityQ = new TutorPriorityQ();
        tutorPriorityQ.run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        s.nextLine();
        PQueue pQueue = new PQueue();
        pQueue.queue.add(0, -1);
        for (int i = 0; i < count; i++) {
            String operation = s.nextLine();
            Operation oper = build(operation);
            if (oper.isExtractMax) {
                System.out.println(pQueue.extractMax());
            }else {
                pQueue.insert(oper.insertVal);
            }
        }
    }
}
