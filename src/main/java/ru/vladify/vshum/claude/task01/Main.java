package ru.vladify.vshum.claude.task01;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nHello World from Java 25!\n");
//        task1();
        task2();
//          task3().run();
//          task3().start();
//        task4();
//        Thread.sleep(1000); // for task4
//        task5();
    }

    public static void task1() throws InterruptedException {
        Runnable ex = () -> {
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " № - " + i);
            }
        };

        Thread thread = new Thread(ex);
        thread.start();
        thread.join();

        System.out.println("task1 Ready!\n");
    }

    public static void task2() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 1; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + " № - " + i);
            }
        };
        Thread thread = new Thread(runnable, "worker-1");
        Thread thread2 = new Thread(runnable, "worker-2");
        Thread thread3 = new Thread(runnable, "worker-3");

        thread.start();
        thread2.start();
        thread3.start();


        System.out.println("task2 is going!");
    }

    public static Thread task3() throws InterruptedException {
        Runnable runnable = () -> System.out.println("Current thread name: " + Thread.currentThread().getName() + "\n");

        System.out.println("task3 is going!");

        return new Thread(runnable);
    }

    public static void task4() throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() +
                        " tick" +
                        " is daemon : " + Thread.currentThread().isDaemon());
            }
        };

        Thread daemon = new Thread(runnable);
        daemon.setDaemon(true); // destroy thread when main thread is stopped
        daemon.start();

        System.out.println("task4 is going!");
    }

    public static void task5() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        System.out.println("Thread state: " + thread.getState());

        thread.start();
        System.out.println("Thread state: " + thread.getState());

        thread.join();
        System.out.println("Thread state: " + thread.getState());

        System.out.println("task5 is going!");
    }
}
