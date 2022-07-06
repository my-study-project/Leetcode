package com.js.thread1;

public class ThreadSafe extends Thread {
    public volatile boolean exit = false;
//    一般 run()方法执行完，线程就会正常结束，然而，常常有些线程是伺服线程。它们需要长时间的
//    运行，只有在外部某些条件满足的情况下，才能关闭这些线程。使用一个变量来控制循环，例如：
//    最直接的方法就是设一个 boolean 类型的标志，并通过设置这个标志为 true 或 false 来控制 while
//    循环是否退出，代码示例：
    @Override
    public void run() {
        while (!exit) {
            //do something
            System.out.println("test-thread1");
            exit = true;
        }
    }
}