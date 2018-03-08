package com.yunjae.session3.recipe6;

import java.util.ArrayList;
import java.util.List;

public class FileGenerator {
    public static List<String> generateFile(int size) {
        List<String> file = new ArrayList<>();
        for (int i=0; i<size; i++) {
            file.add("Lorem ipsum dolor sit amet, consectetur adipisc " + i);
        }
        return file;
    }
}
