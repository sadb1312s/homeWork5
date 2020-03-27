package com.company.threads;

import com.company.employees.Greeter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadUtils {
    //exercises with threads

    public static void runTogether(Runnable... threads){

        ExecutorService service = Executors.newFixedThreadPool(threads.length);

        for(Runnable r : threads){
            service.submit(r);
        }
        service.shutdown();

        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void run(Runnable r){

    }

    private static void waitAll(){

    }

}
