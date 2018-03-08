package com.yunjae.session3.recipe5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = PersonGenerator.generatePersionList(10);

        System.out.println("******************************************");
        System.out.println("Original list)");
        persons.parallelStream().forEach(p -> {
            System.out.printf("%s, s\n", p.getLastName(), p.getFirstName());
        });
        System.out.println("******************************************");
        System.out.println("\n");

        System.out.println("******************************************");
        System.out.println("List without duplicate");
        persons.parallelStream().distinct().forEach(p -> {
            System.out.printf("%s, s\n", p.getLastName(), p.getFirstName());
        });
        System.out.println("******************************************");
        System.out.println("\n");


        System.out.println("******************************************");
        System.out.println("Array of numbers without duplicate");
        Integer[] numbers = {1,2,3,2,5,6,3,7,3,4,8,9};
        Arrays.stream(numbers).parallel().distinct().forEach(p -> {
            System.out.printf("Number : %d\n", p);
        });
        System.out.println("******************************************");
        System.out.println("\n");


        System.out.println("******************************************");
        System.out.println("Filter with persons");
        persons.parallelStream().filter(p -> p.getSalary() < 3000)
                .forEach(p -> System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName()));
        System.out.println("******************************************");
        System.out.println("\n");
    }
}
