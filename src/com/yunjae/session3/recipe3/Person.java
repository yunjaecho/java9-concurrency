package com.yunjae.session3.recipe3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode(exclude = {"id", "birthDate", "salary", "coeficient"})
public class Person implements Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int salary;
    private double coeficient;

    @Override
    public int compareTo(Person otherPersion) {
        int compareLastNames = this.getLastName().compareTo(otherPersion.getLastName());
        if (compareLastNames != 0) {
            return compareLastNames;
        } else {
            return this.getFirstName().compareTo(otherPersion.getFirstName());
        }

    }

    /**
     * apache common-lang3 used it
     * @return
     */
    /*@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }*/
}
