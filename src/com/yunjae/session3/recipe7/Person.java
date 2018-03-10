package com.yunjae.session3.recipe7;

import lombok.Data;
import lombok.ToString;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 * lombok @EqualsAndHashCode has override equals method auto create
 */
@Data
@ToString
public class Person implements Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int salary;
    private double coeficient;

    public static Comparator<Person> comparator = Comparator
            .comparing(Person::getFirstName)
            .thenComparing(Person::getLastName);



    @Override
    public int compareTo(Person otherPersion) {
        return comparator.compare(this, otherPersion);
    }

    @Override
    public boolean equals(Object object) {
        return this.compareTo((Person)object) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
