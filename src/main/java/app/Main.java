package app;

import app.model.AnagramFinder;
import app.model.AnagramFinderImpl;
import app.model.BigFileAnagramFinder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {

    public static String pathToFile;

    public static void main(String[] args) throws IOException {

        if (args.length != 1) System.out.println("Incorrect input");

        else {
            pathToFile = args[0];

            AnagramFinder anagramFinder = new AnagramFinderImpl();

            if (!isFileBiggerThen100MB()){
                anagramFinder = new BigFileAnagramFinder();
            }
            anagramFinder.printAllAnagrams(pathToFile);
            }
    }

    private static boolean isFileBiggerThen100MB() throws IOException{
      return Files.size(Path.of(pathToFile)) / 1_000_000 > 100;
    }
}
