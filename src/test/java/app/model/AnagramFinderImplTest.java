

import app.model.AnagramFinder;
import app.model.AnagramFinderImpl;
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

        List<Set<String>> listFromFile = finder.getListOfAnagrams(Path.of("src/test/resources/sample.txt"));
        listFromFile.sort(Comparator.comparingInt(Set::size));

        List<String> allWordInFile = listFromFile.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertEquals(2,listFromFile.size());
        assertTrue(listFromFile.get(0).containsAll(Arrays.asList("cat","act")));
        assertTrue(listFromFile.get(1).containsAll(Arrays.asList("acre","care","race")));
        assertFalse(allWordInFile.contains("tree"));

    }

    @Test
    void getKeySetTest(){
        assertEquals(AnagramFinder.getKey("dog"),AnagramFinder.getKey("god"));
    }

}