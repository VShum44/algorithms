package ru.vladify.vshum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Real processors - " + Runtime.getRuntime().availableProcessors());

        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .collect(Collectors.toList());

        // Разогрев JIT
        numbers.stream().filter(n -> n % 2 == 0).count();

        // Последовательный стрим
        long time1 = System.currentTimeMillis();
        long count1 = numbers.stream()
                .filter(n -> {
                    // эмуляция тяжёлой работы
                    long acc = 0;
                    for (int i = 0; i < 1_000_000; i++) {
                        acc += i;
                    }
                    return n % 2 == 0;
                })
                .count();
        long time2 = System.currentTimeMillis();
        System.out.println("Последовательно: " + (time2 - time1) + " мс, чётных: " + count1);

        // Параллельный стрим
        long time3 = System.currentTimeMillis();
        long count2 = numbers.parallelStream()
                .filter(n -> {
                    // эмуляция тяжёлой работы
                    long acc = 0;
                    for (int i = 0; i < 1_000_000; i++) {
                        acc += i;
                    }
                    return n % 2 == 0;
                })
                .count();
        long time4 = System.currentTimeMillis();
        System.out.println("Параллельно: " + (time4 - time3) + " мс, чётных: " + count2);
    }
}
