import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        if (word.length() <= 8) { // слово должно быть не больше восьми элементов
            if (wordsList.contains(word)) { // проверка есть ли подобное слово в мапе
                System.out.println("Ты типо читер?\nТакое слово уже есть в списке");
            } else {
                wordsList.add(word);
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
