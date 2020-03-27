package com.company.threads;

import com.company.employees.Greeter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadUtils {
    //exercises with threads

    public static void runTogether(Runnable... threads){
        System.out.println("runTogether");
        ExecutorService service = Executors.newFixedThreadPool(threads.length);

        for(Runnable r : threads){
            service.submit(r);
        }
        System.out.println("all thread start, return");


        waitAll(service);
    }

    public static void runInOrder(Runnable... threads){
        System.out.println("runInOrder");
        ExecutorService service = Executors.newFixedThreadPool(threads.length);

        for(Runnable r : threads){
            service.submit(r);
        }

        waitAll(service);
        System.out.println("all thread stop, return");
    }

    static private void waitAll(ExecutorService service){
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
