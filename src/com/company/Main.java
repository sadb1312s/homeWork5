package com.company;

import com.company.arrays.ArraysUtils;
import com.company.employees.Greeter;
import com.company.employees.utils.EmployeeUtils;
import com.company.employees.Employee;
import com.company.employees.Measurable;
import com.company.files.FilesUtils;
import com.company.sequences.IntSequence;
import com.company.threads.ThreadUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//chapter 3 interferes and lambda
public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Andrey",5006);
        Employee e2 = new Employee("Oleg",5002);

        Measurable[] objects = new Employee[] {e1, e2};
        EmployeeUtils utils = new EmployeeUtils();

        //ex 1
        System.out.println("--- ex 1 ---");
        System.out.println(utils.average(objects));

        //ex 2
        System.out.println("--- ex 2 ---");
        System.out.println((utils.largest(objects)));

        //ex 3
        System.out.println("--- ex 3 ---");
        utils.printSuper(String.class);
        System.out.println();
        utils.printSuper(List.class);

        //ex 4
        System.out.println("--- ex 4 ---");
        IntSequence sequence = IntSequence.of(3,1,4,1,5,9);
        System.out.println(sequence);
        while (sequence.hasNext()){
            System.out.println(sequence.next());
        }

        //ex 5
        System.out.println("--- ex 5 ---");
        System.out.println(IntSequence.constant(5));

        System.out.println("--- ex 8 ---");
        //ex 8
        String[] strs = {"мама мыла","qqq","мама мыла раму!","qq","q","мама",};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strs));
        ArraysUtils utils1 = new ArraysUtils();
        utils1.luckySort(list, (Comparator.comparingInt(String::length)));
        System.out.println(list);

        //ex 9
        System.out.println("--- ex 9 threads ---");

        Runnable r1 = new Greeter(20,"Дмитрий");
        Runnable r2 = new Greeter(20,"Андрей");
        ThreadUtils.runTogether(r1,r2);

        //ex 10
        /*System.out.println("--- ex 10 ---");
        Greeter.runInOrder(r1,r2);
        Greeter.runTogether(r1,r2);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //ex 11
        System.out.println("--- ex 11 ---");
        String path = "D:/test";
        FilesUtils filesUtils = new FilesUtils(path);

        filesUtils.getSubDir();

        //ex 12
        System.out.println("--- ex 12 ---");
        filesUtils.getFiles("odp");

        //ex 13
        System.out.println("--- ex 13 ---");
        File[] files = filesUtils.getFileAndDir();
        files = filesUtils.sortFile(files);
        System.out.println(Arrays.toString(files));

    }


}
