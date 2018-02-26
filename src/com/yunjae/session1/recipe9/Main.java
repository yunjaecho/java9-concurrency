package com.yunjae.session1.recipe9;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        ReportRequest faceRequest = new ReportRequest("Face", service);
        ReportRequest onlineRequest = new ReportRequest("Online", service);

        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);

        ReportProcessor processor = new ReportProcessor(service);
        Thread senderThread = new Thread(processor);

        System.out.println("Main: Starting the Threads");
        faceThread.start();
        onlineThread.start();
        senderThread.start();

        System.out.println("Main: Shutdown then executor");
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.stopProcessing();
        System.out.println("Main : Ends");
    }
}
