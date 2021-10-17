package ru.rblednov.tutors.multithreding;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class PingPong {
    public static final String lockObject = "1";
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
                synchronized (lockObject) {
                    lockObject.notify();
                    System.out.println(rName);
                    try {
                        lockObject.wait();
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
                synchronized (lockObject) {
                    lockObject.notify();
                    System.out.println(rName);
                    try {
                        lockObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        forkJoinPool.submit(ping);
        ForkJoinTask<?> forkJoinTask = forkJoinPool.submit(pong);
        forkJoinTask.join();
        System.out.println("end main");
    }
}
