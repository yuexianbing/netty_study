package com.ybin.start.netty.s4;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import org.junit.Test;

import java.util.concurrent.ThreadFactory;

/**
 * @author yuebing
 * @version 1.0
 * @Date 2018/7/23
 * @category
 */
public class FastThreadLocalTest {

    static FastThreadLocal<Object> fastThreadLocal1 = new FastThreadLocal<Object>() {
        @Override
        protected Object initialValue() throws Exception {
            return new Object();
        }
    };

    static FastThreadLocal<Object> fastThreadLocal2 = new FastThreadLocal<Object>() {
        @Override
        protected Object initialValue() throws Exception {
            return new Object();
        }
    };

    public static void main(String[] arg) {
        Thread thread1 = new ThreadDemo().newThread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Object o1 = fastThreadLocal1.get();
                    System.out.println(String.format("[thread:%s-对象:%s]", Thread.currentThread().getName(), o1));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("----");
                    }
                }
            }
        });

        Thread thread2 = new ThreadDemo().newThread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    Object o2 = fastThreadLocal2.get();
                    System.out.println(String.format("[thread:%s-对象:%s]", Thread.currentThread().getName(), o2));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("++++++");
                    }

                }
            }
        });

        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class ThreadDemo implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new FastThreadLocalThread(r);
        }
    }
}
