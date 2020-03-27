package com.company.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Greeter implements Runnable {
    private int n;
    private String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for(int i = 0; i < n; i++){
            System.out.println("Hello "+target);
        }
    }

    public static void runInOrder(Runnable... tasks){
        System.out.println("runInOrder");

        for(Runnable r : tasks){
            r.run();
        }

        System.out.println("stop");
    }
}
