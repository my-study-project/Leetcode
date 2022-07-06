package com.js.thread2;

public class ThreadSafe extends Thread {
    @Override
    public void run() {
        while (!isInterrupted()) {
            //非阻塞过程中通过判断中断标志来退出
            try {
                System.out.println(" Test thread2");
                interrupt();
                //阻塞过程捕获中断异常来退出
            } catch (Exception e) {
                e.printStackTrace();
                break;//捕获到异常之后，执行 break 跳出循环
            }
        }
    }
}