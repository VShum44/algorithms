package ru.vladify.vshum.claude.task02.task02_03;

public class ReentrantDemo {
    private volatile int counter;

    public synchronized void outer(){
        System.out.println("Get into outer " + Thread.currentThread().getName());
        inner();
        System.out.println("Get out from outer " + Thread.currentThread().getName());
    }

    public synchronized void inner(){
        System.out.println("Get into inner " +  Thread.currentThread().getName());
        counter++;
        System.out.println("Count counter " + counter + " " + Thread.currentThread().getName());
        System.out.println("Get out from inner "  + Thread.currentThread().getName());
    }

    public int getCounter(){
        return counter;
    }
}
