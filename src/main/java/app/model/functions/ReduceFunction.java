package app.model.functions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public class ReduceFunction implements BinaryOperator<Map<String, Set<String>>>, Serializable {

    private static final long serialVersionUID = 1234567L;

    @Override
    public Map<String, Set<String>> apply(Map<String, Set<String>> map1, Map<String, Set<String>> map2) {

        String key = map2.keySet().stream().findFirst().orElseThrow();
        if(!map1.containsKey(key)) map1.put(key,new HashSet<>());
        map1.get(key).addAll(map2.get(key));
        return map1;
    }
}
