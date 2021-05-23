package app.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;


public class AnagramFinderImpl implements AnagramFinder {

    @Override
    public void printAllAnagrams(Path path) throws IOException {
        getListOfAnagrams(path).forEach(System.out::println);
    }

    public List<Set<String>> getListOfAnagrams(Path path) throws IOException {

        Map<String, Set<String>> groupedWords = groupWordsByKey(path);

        List<Set<String>> allAnagrams = new CopyOnWriteArrayList<>();

        groupedWords.values().stream()
                .parallel()
                .filter(words -> words.size()>1)
                .forEach(allAnagrams::add);

        return allAnagrams;
    }

    @Override
    public void printAllAnagrams(String path) throws IOException {
        printAllAnagrams(Path.of(path));
    }

    public Map<String,Set<String>> groupWordsByKey(Path path) throws IOException {

      try(Stream<String> stream = Files.lines(path)) {
                
            return stream
                        .parallel()
                        .collect(Collectors.groupingBy(
                                AnagramFinder::getKey,
                                ConcurrentHashMap::new,
                                Collectors.toSet())
                        );
        }
    }
}
