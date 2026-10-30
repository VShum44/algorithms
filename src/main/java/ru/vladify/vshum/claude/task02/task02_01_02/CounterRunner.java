package ru.vladify.vshum.claude.task02.task02_01_02;

import ru.vladify.vshum.claude.task02.task02_01_02.interfaces.Counter;

public class CounterRunner implements Runnable {

    private final Counter counter;
    private final int count;

    public CounterRunner(Counter counter, int count) {
        this.counter = counter;
        this.count = count;
    }

    @Override
    public void run() {
        counter.increment(count);
    }
}
