package ru.rblednov.tutors.abstracttutor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class Tutor {
    public static final String block1 = "1";
    public static final String block2 = "2";

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("start main");
        Runnable ping = () -> {
            String rName = "ping ";
            System.out.println("#" + rName + "# start");
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (block1){
                    block1.notify();
                    System.out.println(rName);
                    try {
                        block1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable pong = () -> {
            String rName = "PONG ";
            System.out.println("#" + rName + "# start");
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (block1){
                    block1.notify();
                    System.out.println(rName);
                    try {
                        block1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);
        t1.start();
        t2.start();
        System.out.println("end main");
    }
}
