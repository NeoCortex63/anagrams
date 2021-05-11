package app.model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public interface AnagramFinder {

    void printAllAnagrams(Path path) throws IOException;

    void printAllAnagrams(String path) throws IOException;

    //counting amount of each letter
    static String getKey(String word){

        char[] chars = word.toLowerCase().toCharArray();

        int[] key = new int[26];

        for (char c : chars) {

            key[c - 'a']++;
        }

        return Arrays.toString(key);
    }
}
