package com.wyhw.pmp;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程同步测试
 * @author wanyanhw
 * @date 2022/5/7 11:42
 */
public class ThreadSynchronizeTest {

    private volatile int volatileCount = 0;

    /**
     * 测试使用 volatile 关键字实现线程同步
     */
    @Test
    public void volatileTest() {
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            new Thread(() -> System.out.println(volatileCount + "+" + index + "=" + (volatileCount += index))).start();
        }
    }

    private int synchronizeCount = 0;

    /**
     * 测试使用 synchronized 实现代码块加锁
     */
    @Test
    public void synchronizeTest() {
        while (true) {
            // 存款线程
            new Thread(() -> {
                synchronized (this) {
                    int thisValue = (int) (Math.random() * 100);
                    System.out.print(this.synchronizeCount + "+" + thisValue + "=");
                    this.synchronizeCount += thisValue;
                    System.out.print(this.synchronizeCount + " ");
                    System.out.print("存入: " + thisValue + "; ");
                    System.out.println("存入后余额: " + this.synchronizeCount);
                }
            }).start();

            // 取款线程
            new Thread(() -> {
                synchronized (this) {
                    if (this.synchronizeCount <= 0) {
                        return;
                    }
                    int thisValue = (int) (Math.random() * synchronizeCount);
                    System.out.print(this.synchronizeCount + "-" + thisValue + "=");
                    this.synchronizeCount -= thisValue;
                    System.out.print(this.synchronizeCount + " ");
                    System.out.print("取出: " + thisValue + "; ");
                    System.out.println("取出后余额: " + this.synchronizeCount);
                }
            }).start();

            System.out.println();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 ReentrantLock 对象实现加锁
     */
    @Test
    public void lockTest() {
        ReentrantLock reentrantLock = new ReentrantLock();
        while (true) {
            // 存款线程
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    System.out.println("存款锁定。。。。。。");
                    int thisValue = (int) (Math.random() * 100);
                    System.out.print(this.synchronizeCount + "+" + thisValue + "=");
                    this.synchronizeCount += thisValue;
                    System.out.print(this.synchronizeCount + " ");
                    System.out.print("存入: " + thisValue + "; ");
                    System.out.println("存入后余额: " + this.synchronizeCount);
                } finally {
                    reentrantLock.unlock();
                }
            }).start();

            for (int i = 0; i < 3; i++) {
                // 取款线程
                new Thread(() -> {
                    reentrantLock.lock();
                    try {
                        System.out.println("取款锁定。。。。。。");
                        if (this.synchronizeCount <= 0) {
                            return;
                        }
                        int thisValue = (int) (Math.random() * synchronizeCount);
                        System.out.print(this.synchronizeCount + "-" + thisValue + "=");
                        this.synchronizeCount -= thisValue;
                        System.out.print(this.synchronizeCount + " ");
                        System.out.print("取出: " + thisValue + "; ");
                        System.out.println("取出后余额: " + this.synchronizeCount);
                    } finally {
                        reentrantLock.unlock();
                    }
                }).start();
            }

            System.out.println();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
