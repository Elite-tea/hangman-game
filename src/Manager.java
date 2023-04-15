import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

public class Manager {

    private HashMap<String, Character> wordsMap; // map with words, where key is a word and values are letters

    public Manager() {
        this.wordsMap = new HashMap<>();
    }

    public HashMap<String, Character> getWordsMap() {
        return wordsMap;
    }

    public void setWordsMap(HashMap<String, Character> wordsMap) {
        this.wordsMap = wordsMap;
    }

    public void addWord(String word) {
        if (word.length() <= 8) { // the word mustn't be more than six characters
            if (wordsMap.containsKey(word)) { // checking if there's already similar word in a map
                System.out.println("Are you a cheater or something?\nWe've already got the same word");
            } else {
                char[] wordToArray = word.toCharArray();
                for (int i = 0; i < wordToArray.length; i++) {
                    char letters = (char) i; // casting to char type
                    wordsMap.put(word, letters); // adding values into a map
                }
                System.out.println("All done! The word has gone!");
            }
        } else {
            System.out.println("Word must contain only six letters!");
        }
    }

    public void printHowToPlay() {
        List<String> content = readFileContents("resources/Document.txt");
        for (int i = 0; i < content.size(); i++) {
            String[] sentences = content.get(i).split("\n"); // splitting a text file into sentences
            System.out.println(Arrays.toString(sentences)); // printing sentences
        }
    }

    public void printAnIDEA() {
        // there should be a link to some stupid video on YouTube
    }

    List<String> readFileContents(String path) { // there's a method to read files
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

}
