package app.model.functions;

import app.model.Word;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class StringToMapMappingFunction implements Function<String, Map<String, Set<Word>>>, Serializable {

    private static final long serialVersionUID = 1234567L;

    @Override
    public Map<String, Set<Word>> apply(String s) {

        Word word = new Word(s);

        Map<String, Set<Word>> groupedWords = new HashMap<>();
        
        Set<Word> words = new HashSet<>();

        words.add(word);

        String key = word.getKey();

        groupedWords.put(key,words);
        
        return groupedWords;
    }
}
