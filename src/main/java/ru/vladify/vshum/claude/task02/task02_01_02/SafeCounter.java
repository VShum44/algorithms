package ru.vladify.vshum.claude.task02.task02_01_02;

import ru.vladify.vshum.claude.task02.task02_01_02.interfaces.Counter;

public class SafeCounter implements Counter {

    private int counter;
    private final Object lock = new Object();

    // Exclude race condition to shared data "counter"
    public void increment(int count) {
        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                counter++;
            }
        }

    }

    // synchronized for safe reading
    public synchronized int getCounter() {
        return counter;
    }
}

