package com.yunjae.session2.recipe2;

import java.util.Random;

public class DocumentMock {
    private String[] words = {"Watch", "full", "episodes", "of",
            "current", "and", "the", "classic", "NBC", "shows", "online"};

    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter = 0;
        String[][] document = new String[numLines][numWords];
        Random random = new Random();
        for (int i=0; i<numLines; i++) {
            for (int j=0; j<numWords; j++) {
                int index = random.nextInt(words.length-1);
                document[i][j]=words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }

        System.out.printf("DocumentMoc: The word appears %d times int document.\n", counter);
        return document;
    }
}
