package com.js.thread1;

public class TestMain {
    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();

        threadSafe.start();
        String s1 = "sssss";

        try {
            threadSafe.join();
            threadSafe.getName();
            ;
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
