package com.yunjae.session3.recipe8;



import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = PersonGenerator.generatePersionList(10);

        System.out.println("******************************************");
        int maxSalary = persons.parallelStream().mapToInt(Person::getSalary).max().getAsInt();
        int minSalary = persons.parallelStream().mapToInt(Person::getSalary).min().getAsInt();
        System.out.printf("Salaries are between %d and %d\n", maxSalary, minSalary);
        System.out.println("******************************************");
        System.out.println("\n");

        boolean condition;
        System.out.println("******************************************");
        condition = persons.parallelStream().allMatch(p -> p.getSalary() > 0);
        System.out.printf("Salary > 0 : %b\n", condition);
        System.out.println("******************************************");
        System.out.println("\n");


        System.out.println("******************************************");
        condition = persons.parallelStream().anyMatch(p -> p.getSalary() > 50000);
        System.out.printf("Any Salary > 50000 : %b\n", condition);
        System.out.println("******************************************");
        System.out.println("\n");

        System.out.println("******************************************");
        condition = persons.parallelStream().noneMatch(p -> p.getSalary() > 50000);
        System.out.printf("None Salary > 50000 : %b\n", condition);
        System.out.println("******************************************");
        System.out.println("\n");
    }
}
