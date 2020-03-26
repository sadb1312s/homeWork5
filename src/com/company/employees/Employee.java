package com.company.employees;

import javax.print.DocFlavor;
import java.util.Collection;
import java.util.Random;

public class Employee implements Measurable{

    private int salary;
    private String name;

    public Employee(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public double getMeasure() {
        //measure emp with some way?
        return salary + new Random().nextInt(10); //it is ok?
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (salary != employee.salary) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = salary;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
