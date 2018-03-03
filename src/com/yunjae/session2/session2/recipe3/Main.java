package com.yunjae.session2.session2.recipe3;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Using the asynchronous methods
 * Implementing program search for files with extension
 * Different execution wasy
 *   - Synchronous  (* Task doesn't return until sent task completes completes execution)
 *   - Asynchronous (* Task returns immediately)
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        FolderProcessor servers = new FolderProcessor("/media/comp1/disk128/servers", "jar");
        FolderProcessor docSources = new FolderProcessor("/media/comp1/disk128/ook_source", "java");
        FolderProcessor softwares = new FolderProcessor("/media/comp1/disk128/software", "sh");

        pool.execute(servers);
        pool.execute(docSources);
        pool.execute(softwares);

        do {
            System.out.println("************************************");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Thread: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("Main: %b - %b - %b\n", servers.isDone(), docSources.isDone(), softwares.isDone());
            System.out.printf("Main: %d - %d - %d\n", servers.getPendingCount(), docSources.getPendingCount(), softwares.getPendingCount());
            System.out.println("************************************");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!servers.isDone()) || (!docSources.isDone()) || (!softwares.isDone()));

        pool.shutdown();

        // Write the number of results calculate by each task
        List<String> results;

        results = servers.getResultList();
        System.out.printf("Servers: %d files fond.\n", results.size());

        results = docSources.getResultList();
        System.out.printf("DocSources: %d files fond.\n", results.size());

        results = softwares.getResultList();
        System.out.printf("Softwares: %d files fond.\n", results.size());

    }
}
