package app.model;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AnagramFinderImplTest {

    @Test
    void getListOfAnagramsTest() throws IOException {
        AnagramFinderImpl finder = new AnagramFinderImpl();

        List<Set<Word>> listFromFile = finder.getListOfAnagrams(Path.of("src/test/resources/sample.txt"));
        listFromFile.sort(Comparator.comparingInt(Set::size));

        List<Word> allWordsInFile = listFromFile.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertEquals(2,listFromFile.size());

        assertTrue(listFromFile.get(0).containsAll(Arrays.asList(new Word("cat"),new Word("act"))));

        assertTrue(listFromFile.get(1).containsAll(Arrays.asList(new Word("acre"),
                new Word("care"),
                new Word("race"))));
        assertFalse(allWordsInFile.contains(new Word("tree")));

    }

}
