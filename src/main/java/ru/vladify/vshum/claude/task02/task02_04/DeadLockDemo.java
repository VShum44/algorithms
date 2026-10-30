package ru.vladify.vshum.claude.task02.task02_04;

public class DeadLockDemo {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " get lock1 in method1");
            try {Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " get lock2 in method1");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " get lock2 in method2");
            try {Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " get lock1 in method2");
            }
        }
    }
}
