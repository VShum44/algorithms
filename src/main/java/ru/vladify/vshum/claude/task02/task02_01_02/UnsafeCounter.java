package ru.vladify.vshum.claude.task02.task02_01_02;

import ru.vladify.vshum.claude.task02.task02_01_02.interfaces.Counter;

public class UnsafeCounter implements Counter {

    private int counter;

    public void increment(int count) {
        for (int i = 0; i < count; i++) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
