package com.yunjae.session3.recipe4;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = PersonGenerator.generatePersionList(10);

        System.out.println("******************************************");
        System.out.println("Parallel forEach()");
        persons.parallelStream().forEach(p -> {
            System.out.printf("%s, s\n", p.getLastName(), p.getFirstName());
        });
        System.out.println("******************************************");
        System.out.println("\n");


        List<Double> doubles = DoubleGenerator.generateDoubleList(10, 100);
        System.out.println("******************************************");
        System.out.println("Parallel forEachOrdered() with numbers");
        doubles.parallelStream().sorted().forEachOrdered(n -> {
            System.out.printf("%f \n", n);
        });
        System.out.println("******************************************");
        System.out.println("\n");

        //Peek
        System.out.println("******************************************");
        System.out.println("Peek");
        doubles
                .parallelStream()
                .peek(d -> System.out.printf("Number: %f\n", d))
                .filter(n -> n < 50)
                .peek(d -> System.out.printf("Number: %f\n", d))
                .forEach(d -> System.out.printf("Final Step Number %f\n", d));
        System.out.println("******************************************");
        System.out.println("\n");

    }
}
