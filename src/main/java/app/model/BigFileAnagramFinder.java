package app.model;

import app.model.functions.ReduceFunction;
import app.model.functions.StringToMapMappingFunction;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import java.io.Serializable;
import java.nio.file.Path;

public class BigFileAnagramFinder implements AnagramFinder, Serializable {

    private static final long serialVersionUID = 1234567L;

    @Override
    public void printAllAnagrams(Path path) {

        SparkConf conf = new SparkConf().setMaster("local").setAppName("anagrams");

        JavaSparkContext context = new JavaSparkContext(conf);

        JavaRDD<String> stringJavaRDD = context.textFile(path.toString());

        ReduceFunction reduceFunction = new ReduceFunction();

        StringToMapMappingFunction mappingFunction = new StringToMapMappingFunction();

        stringJavaRDD.map(mappingFunction::apply)
                .reduce(reduceFunction::apply)
                .values().stream()
                .filter(set -> set.size() > 1)
                .forEach(System.out::println);

    }

    @Override
    public void printAllAnagrams(String path){
        printAllAnagrams(Path.of(path));
    }
}
