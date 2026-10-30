package ru.vladify.vshum.qwen.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LogParserApp {

    public static List<PseudoFile> files;

    static {
        files = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            files.add(new PseudoFile("log_" + i + ".txt"));
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable processor = () -> {
            int filesProceed = 0;
            boolean filesToProceed = true;
            while (filesToProceed) {
                PseudoFile pseudoFile = null;
                for (PseudoFile file : files) {
                    if (!file.isProcessing() && !file.isProcessed()) {
                        pseudoFile = file;
                        pseudoFile.setProcessing(true);
                        break;
                    }
                }

                if (pseudoFile == null) {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " started reading  " + pseudoFile.getName());
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(200,1000));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted. Proceed " + filesProceed + " files");
                    Thread.currentThread().interrupt();
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " finish reading " + pseudoFile.getName());
                pseudoFile.setProcessed(true);
                pseudoFile.setProcessing(false);
                filesProceed = filesProceed + 1;
                filesToProceed = files.stream().anyMatch(file -> !file.isProcessed());
            }
        };

        Thread fileProcessor = new Thread(processor, "*FileProcessor1*");
        Thread fileProcessor2 = new Thread(processor, "*FileProcessor2*");
        Thread fileProcessor3 = new Thread(processor,  "*FileProcessor3*");

        fileProcessor.start();
        fileProcessor2.start();
        fileProcessor3.start();

        Thread.sleep(3000);

        fileProcessor.interrupt();
        fileProcessor2.interrupt();
        fileProcessor3.interrupt();

        fileProcessor.join();
        fileProcessor2.join();
        fileProcessor3.join();

        System.out.println("Все потоки остановлены, приложение закрывается.");
    }
}
