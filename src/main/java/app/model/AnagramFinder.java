package app.model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public interface AnagramFinder {

    void printAllAnagrams(Path path) throws IOException;

    void printAllAnagrams(String path) throws IOException;

}
