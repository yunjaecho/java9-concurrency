package com.yunjae.session3.recipe6;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = PersonGenerator.generatePersionList(10);

        System.out.println("******************************************");
        DoubleStream ds = persons.parallelStream().mapToDouble(p -> p.getSalary());
        ds.distinct().forEach(d -> {
            System.out.printf("Salary : %f\n", d);
        });

        long size = persons.parallelStream().mapToDouble(p -> p.getSalary()).distinct().count();
        System.out.printf("Size :  %d\n", size);
        System.out.println("******************************************");
        System.out.println("\n");


        System.out.println("******************************************");
        List<BasicPerson> basicPersons = persons.parallelStream().map(p -> {
                    return new BasicPerson(p.getFirstName() + " " + p.getLastName(),
                            getAge(p.getBirthDate()));
                }
               ).collect(Collectors.toList());

        basicPersons.forEach(b -> System.out.printf("%s, %d\n", b.getName(), b.getAge()));
        System.out.println("******************************************");
        System.out.println("\n");


    }

    private static long getAge(Date birthDate) {
        LocalDate start = birthDate.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        long ret = ChronoUnit.YEARS.between(start, now);
        return ret;
    }
}
