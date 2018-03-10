package com.yunjae.session3.recipe7;


import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {9,2,5,7,4,5,7,3,6,1,8};
        System.out.println("******************************************");
        Arrays.stream(numbers).parallel().sorted().forEachOrdered(System.out::println);
        System.out.println("******************************************");
        System.out.println("\n");

        List<Person> persons = PersonGenerator.generatePersionList(10);

        Person person;
        TreeSet<Person> personSet = new TreeSet<>(persons);

        for(Person p : personSet) {
            System.out.println(p.getFirstName() + ", " + p.getLastName());
        }

        System.out.println("******************************************");
        System.out.println("\n");

        for (int i=0; i<10; i++) {
            System.out.printf("***********   %d   **********\n", i);
            person = personSet.stream().parallel().limit(1).collect(toList()).get(0);
            System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());

            person = personSet.stream().unordered().parallel().limit(1).collect(toList()).get(0);
            System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());
        }
    }
}
