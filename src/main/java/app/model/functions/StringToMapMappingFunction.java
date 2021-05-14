package app.model.functions;

import app.model.AnagramFinder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class StringToMapMappingFunction implements Function<String, Map<String, Set<String>>>, Serializable {

    private static final long serialVersionUID = 1234567L;

    @Override
    public Map<String, Set<String>> apply(String s) {

        Map<String, Set<String>> groupedWords = new HashMap<>();
        
        Set<String> words = new HashSet<>();
        
        words.add(s);
        
        groupedWords.put(AnagramFinder.getKey(s),words);
        
        return groupedWords;
    }
}
