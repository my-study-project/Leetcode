package com.js;

/**
 * **题目2***
 * 两个线程交替打印1-100的整数，一个打印奇数，一个打印偶数，要求输出结果有序
 */

public class Check implements Runnable {
    private boolean runNow;
    // 定义统一的锁对象，避免同时执行
    private Object lock;
    private int num;
    public Check(boolean runNow, Object lock, int num) {
        this.runNow = runNow;
        this.lock = lock;
        this.num = num;
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new Check(true, lock, 1));
        Thread t2 = new Thread(new Check(false, lock, 2));
        t2.start();
        t1.start();
    }

    @Override
    public void run() {
        // 上锁
        synchronized (lock) {
            //首先如果当前数据 小于 100 正常走逻辑，大于 100 证明执行完成
            while (num <= 100) {
                if (runNow) {
                    runNow = false;
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //成功打印之后唤醒其他线程
                System.out.println(num);
                num += 2;
                lock.notify();
            }
        }
    }
}