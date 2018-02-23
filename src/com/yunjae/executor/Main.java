package com.yunjae.executor;

public class Main {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        Server server = new Server();

        System.out.println("Main : Staring");

        for (int i =0; i < 100; i++) {
            Task task = new Task("Task-" + i);
            server.executeTask(task);
        }

        System.out.println("Main: Shutdown the Executor");
        server.endServer();

        System.out.println("Main: Sending other task");
        Task task = new Task("Rejected task");
        server.executeTask(task);

        System.out.println("Main : end");
    }

    public static void test2() {
        Server server = new Server();

        System.out.println("Main : Staring");

        for (int i =0; i < 100; i++) {
            Task task = new Task("Task-" + i);
            server.executeTask2(task);
        }

        System.out.println("Main: Shutdown the Executor");
        server.endServer2();

        System.out.println("Main: Sending other task");
        Task task = new Task("Rejected task");
        server.executeTask2(task);

        System.out.println("Main : end");
    }
}
