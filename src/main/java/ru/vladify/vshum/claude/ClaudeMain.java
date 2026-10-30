package ru.vladify.vshum.claude;

import ru.vladify.vshum.claude.task02.task02_01_02.CounterRunner;
import ru.vladify.vshum.claude.task02.task02_01_02.SafeCounter;
import ru.vladify.vshum.claude.task02.task02_01_02.UnsafeCounter;
import ru.vladify.vshum.claude.task02.task02_01_02.interfaces.Counter;
import ru.vladify.vshum.claude.task02.task02_03.ReentrantDemo;
import ru.vladify.vshum.claude.task02.task02_04.DeadLockDemo;

import java.util.ArrayList;
import java.util.List;

public class ClaudeMain {

    public static void main(String[] args) throws InterruptedException {

        task_2_1();
        task_2_2();
        task_2_3();
        task_2_4_deadlockRelease();
        task_2_4_deadlock();

    }

    static void task_2_1() throws InterruptedException {

        Counter unsafeCounter = new UnsafeCounter();


        List<Thread> threads = new ArrayList<>();
        final int threadsCount = 100;
        final int iterations = 10_000;

        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(new CounterRunner(unsafeCounter, iterations));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("result unsafe counter number is - " + unsafeCounter.getCounter());
        System.out.println("expected result unsafe counter number is - " + (threadsCount * iterations) + "\n*************");


    }

    static void task_2_2() throws InterruptedException {
        Counter safeCounter = new SafeCounter();

        List<Thread> threads = new ArrayList<>();
        final int threadsCount = 100;
        final int iterations = 10_000;


        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(new CounterRunner(safeCounter, iterations));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("result safe counter number is - " + safeCounter.getCounter());
        System.out.println("expected result safe counter number is - " + (threadsCount * iterations));
    }

    static void task_2_3() throws InterruptedException {
        ReentrantDemo reentrantDemo = new ReentrantDemo();


        List<Thread> threads = new ArrayList<>();
        final int threadsCount = 1000;

        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(reentrantDemo::outer);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("result reentrant demo number is - " + reentrantDemo.getCounter());
    }

    static void task_2_4_deadlock() throws InterruptedException {
        DeadLockDemo deadLockDemo = new DeadLockDemo();

        Thread thread1 = new Thread(deadLockDemo::method1);
        Thread thread2 = new Thread(deadLockDemo::method2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Threads finished - " + thread1.getName() + " " +thread1.getState() +
                "\n " +thread2.getName() + " - " + thread2.getState());
    }

    static void task_2_4_deadlockRelease() throws InterruptedException {
        DeadLockDemo deadLockDemo = new DeadLockDemo();

        Thread thread1 = new Thread(deadLockDemo::method1);
        Thread thread2 = new Thread(deadLockDemo::method1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Threads finished : \n" + thread1.getName() + " " +thread1.getState() +
                "\n " +thread2.getName() + " - " + thread2.getState());
    }

}
