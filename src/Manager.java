import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

public class Manager {

    private HashMap<String, Character> wordsMap; // мапа слов, где ключ - слово, значения - буквы

    public Manager() {
        this.wordsMap = new HashMap<>();
    }

    public HashMap<String, Character> getWordsMap() {
        return wordsMap;
    }

    public void setWordsMap(HashMap<String, Character> wordsMap) {
        this.wordsMap = wordsMap;
    }

    public void readWords() { // метод для считывания слов из файла
        List<String> content = readFileContents("resources/Words");
        for (int i = 0; i < content.size(); i++) { // разделяю на составные части
            String[] words = content.get(i).split(","); // делю по запятой
            for (int j = 0; j < words.length; j++) { // достаю слова из массива
                String word = words[j]; // получаю отдельное слово
                for (int k = 0; k < word.length(); k++) { // делю слова на буквы
                    char letters = (char) k; // привожу к типу char
                    wordsMap.put(word, letters); // кладу в мапу слова и буквы
                }
            }
        }
    }

    public void addWord(String word) {
        if (word.length() <= 8) { // слово должно быть не больше восьми элементов
            if (wordsMap.containsKey(word)) { // проверка есть ли подобное слово в мапе
                System.out.println("Ты типо читер?\nТакое слово уже есть в списке");
            } else {
                char[] wordToArray = word.toCharArray();
                for (int i = 0; i < wordToArray.length; i++) {
                    char letters = (char) i; // привожу к типу char
                    wordsMap.put(word, letters); // добавляю значения в мапу
                }
                System.out.println("Готово!");
            }
        } else {
            System.out.println("Слово должно быть не больше восьми букв!");
        }
    }

    public void printHowToPlay() {
        List<String> content = readFileContents("resources/Document.txt");
        for (int i = 0; i < content.size(); i++) {
            String[] sentences = content.get(i).split("\n"); // разделяю файл на предложения
            System.out.println(Arrays.toString(sentences)); // печать предложений
        }
    }

    public void printAnIDEA() {
        // здесь любая реализация метода, чисто по рофлу
    }

    List<String> readFileContents(String path) { // метод для считывания файлов
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

}
