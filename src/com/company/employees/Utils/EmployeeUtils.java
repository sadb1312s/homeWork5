package com.company.employees.Utils;

import com.company.employees.Employee;
import com.company.employees.Measurable;

public class EmployeeUtils {
    //exercise 1
    public double average(Measurable[] objects){
        int result = 0;
        for(Measurable o : objects){
            result += o.getMeasure();
        }
        return result / objects.length;
    }

    public Measurable largest(Measurable[] objects){

        return findMax(objects);
    }

    //exercise 2
    private Measurable findMax(Measurable[] objects){

        Employee max = (Employee)objects[0];
        for (int i = 1; i < objects.length; i++) {
            Employee t = (Employee)objects[i];
            if (t.getSalary() > max.getSalary()){
                max = t;
            }
        }

        return max;

    }

    //exercise 3
    public void printSuper(Class c){
        Class superC = c.getSuperclass();
        System.out.println(c.getName());
        System.out.println("super class");
        System.out.println(superC);

        Class[] interfaces = c.getInterfaces();

        System.out.println("super interfaces");
        for(Class o : interfaces){
            System.out.println(o);
        }
    }


}
