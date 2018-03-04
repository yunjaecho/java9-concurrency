package com.yunjae.session3.recipe1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Creating Stream from Different Sources
 */
public class Main {
    public static void main(String[] args) {
        // Create a stream from a collection
        System.out.println("******************************************");
        System.out.println("From a Collection");
        List<Person> persons = PersonGenerator.generatePersionList(10000);
        Stream<Person> personStream = persons.parallelStream();
        System.out.printf("Number of persons %d\n", personStream.count());
        System.out.println("******************************************");
        System.out.println("\n");

        // Using a generator
        System.out.println("******************************************");
        System.out.println("From a Supplier");
        Supplier<String> supplier = new MySupplier();
        Stream<String> generatorSteam = Stream.generate(supplier);
        generatorSteam.parallel().limit(10).forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println("\n");

        // From predefined elements
        System.out.println("******************************************");
        System.out.println("From a predefined set of elements");
        Stream<String> elementsStream = Stream.of("Peter", "John", "Mary");
        elementsStream.parallel().forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println("\n");


        // From a File
        System.out.println("******************************************");
        System.out.println("From a File");
        String filePath = "/media/comp1/disk128/book_source/Learning-Akka-master/throttler-messages/src/main/scala/com/akka/packt/Thottler.scala";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Stream<String> fileLines = br.lines();
            System.out.printf("Number of lines in the file: %d\n\n", fileLines.parallel().count());
            System.out.println("******************************************");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");


        // From a directory
        System.out.println("******************************************");
        System.out.println("From a Directory");
        try {
            Stream<Path> directoryContent = Files.list(Paths.get(System.getProperty("user.home")));
            System.out.printf("Number of elements (files and folders) : %d\n\n", directoryContent.parallel().count());
            directoryContent.close();
            System.out.println("******************************************");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");


        // From an array
        System.out.println("******************************************");
        System.out.println("From an Array");
        String[] array = {"1", "2", "3", "4", "5"};
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.parallel().forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println("\n");

        // Random numbers
        System.out.println("******************************************");
        System.out.println("Random number generators");
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(10); // 10 DoubleStream create
        double doubleStreamAverage = doubleStream
                .parallel()
                .peek(System.out::println)  // debug
                .average()
                .getAsDouble();
        System.out.printf("\n Double Stream Average %f\n", doubleStreamAverage);
        System.out.println("******************************************");
        System.out.println("\n");

        // Concatenating streams
        System.out.println("******************************************");
        System.out.println("Concatenating streams");
        Stream<String> stream1 = Stream.of("1", "2", "3", "4");
        Stream<String> stream2 = Stream.of("5", "6", "7", "8");
        Stream<String> finalStream = Stream.concat(stream1, stream2);
        finalStream.parallel().forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println("\n");


    }
}
