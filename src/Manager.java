import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Manager {

    private List<String> wordsList; // лист слов, считывается из файла

    public Manager() {
        this.wordsList = new ArrayList<>();
    }

    public List<String> getWordsList() {
        return wordsList;
    }

    public void setWordsList(List<String> wordsList) {
        this.wordsList = wordsList;
    }

    public void readWordsFile() { // метод для считывания слов из файла
        List<String> content = readFileContents("resources/Words");
        for (String s : content) { // разделяю на составные части
            String[] words = s.split(","); // делю по запятой
            Collections.addAll(wordsList, words);
        }
    }

    public void addWord(String word) {
        readWordsFile();
        String words = "\n" + word + ",";
        if (word.length() == 8) { // слово должно быть не больше восьми элементов
            if (wordsList.contains(word)) { // проверка есть ли подобное слово в листе
                System.out.println("Ты типо читер?\nТакое слово уже есть в списке");
            } else {
                String filePath = "resources/Words"; // считывание файла со списком слов
                try {
                    Files.write(Paths.get(filePath), words.getBytes(), StandardOpenOption.APPEND);
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                System.out.println("Слово " + word + " добавлено");
            }
        } else {
            System.out.println("Слово должно быть не больше восьми букв! Не тупи!");
        }
    }



    public void printHowToPlay() {
        List<String> content = readFileContents("resources/Document.txt");
        for (String s : content) {
            String[] sentences = s.split("\n"); // разделяю файл на предложения
            System.out.println(Arrays.toString(sentences)); // печать предложений
        }
    }

    List<String> readFileContents(String path) { // метод для считывания файлов
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

}
