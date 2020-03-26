package com.company;

import com.company.employees.Utils.EmployeeUtils;
import com.company.employees.Employee;
import com.company.employees.Measurable;

import java.util.List;

//chapter 3 interferes and lambda
public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Andrey",5006);
        Employee e2 = new Employee("Oleg",5002);

        Measurable[] objects = new Employee[] {e1, e2};
        EmployeeUtils utils = new EmployeeUtils();

        //ex 1
        System.out.println(utils.average(objects));
        //ex 2
        System.out.println((utils.largest(objects)));
        //ex 3
        utils.printSuper(String.class);
        System.out.println();
        utils.printSuper(List.class);




    }


}
