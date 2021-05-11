# anagrams
An anagram is a word formed by rearranging the letters of a different word.
The program prints all anagrams from a file.

## Build

```
git clone https://github.com/NeoCortex63/anagrams.git
```
```
cd anagrams
```
```
mvn clean install
```

## Run

After building the **finder.jar**, use following:

```
java -cp finder.jar app.Main <path_to_your_file>
```
There is **dictionary.txt** in the **main/resources** directory, that could be used like example.

```
java -cp finder.jar app.Main src/main/resources/dictionary.txt
```
# About

The class **AnagramFinderImpl** can give a list of anagrams from the file or print all anagrams.
Two words are defined as anagrams if they do share the same letters, but are in a different order. So we can count the quantity of each letter and then compare. The first step was collecting of all words from the file and grouping by the same letters count.
The **AnagramFinder** interface has a static **getKey(String word)** method that accepts a String and returns a String from count of letters:

hello -> [0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

world -> [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0]

I used Map<String, Set<String>> for grouping elements and Set of original words for avoiding duplicates. Map was created by using paralell stream from file, therefore I used **ConcurrentHashMap**. Then I just filtered Sets with
size < 2 (this words do not have anagrams).

I tried to use this method for a huge file and have got **OutOfMemoryError: Java heap space.**
So I decided to use a Apache Spark for a large-scale data processing. The another **AnogramFinder** implementation is **BigFileAnagramFinder**. In Purpose of increasing the Maintainability and code Readability, map and reduce function have been moved to a new package.
The main method takes path to the file as args parameter and print all anagrams. If the file is huge- it uses BigFileAnagramFinder implemetation. If You need to check it, You could change the code and rebuild the project.


I also used a maven-assembly-plugin for building a Fat Jar. It contains all the compiled Java classes from the project, and all compiled Java classes from all JAR files the project depends on. 
