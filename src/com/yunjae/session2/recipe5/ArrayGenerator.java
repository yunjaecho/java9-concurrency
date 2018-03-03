package com.yunjae.session2.recipe5;

import java.util.Random;

/**
 * create of int[] variable instance
 */
public class ArrayGenerator {

    public int[] generatorArray(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i=0; i<size; i++) {
            array[i]=random.nextInt(10);
        }
        return array;
    }

}
