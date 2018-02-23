package com.yunjae.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private final ThreadPoolExecutor executor;

    private final ExecutorService executorService;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        RejectedTaskController controller = new RejectedTaskController();

        executor.setRejectedExecutionHandler(controller);
    }

    public void executeTask(Task task) {
        System.out.printf("Server: A new   has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size : %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count : %d\n", executor.getActiveCount());
        System.out.printf("Server: Task Count : %d\n", executor.getTaskCount());
        System.out.printf("Server: Completed Tasks : %d\n", executor.getCompletedTaskCount());
    }

    public void executeTask2(Task task) {
        System.out.printf("Server: A new   has arrived\n");
        executorService.execute(task);
        System.out.printf("Server: Pool Size : %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count : %d\n", executor.getActiveCount());
        System.out.printf("Server: Task Count : %d\n", executor.getTaskCount());
        System.out.printf("Server: Completed Tasks : %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }

    public void endServer2() {
        executorService.shutdown();
    }

}
