import java.util.List;
import java.util.Random;

public class Game {

    static Manager manager = new Manager();
    static Random generator = new Random();

    public void guessingALetter(char letter) {
        char[] letters = new char[8];
        List<String> localListOfWords = manager.getWordsList(); // создаю новый лист, чтоб сложить туда слова
        String randomWord = localListOfWords.get(generator.nextInt(localListOfWords.size()));
        // получаем рандомное слово из листа
        letters = randomWord.toCharArray();
    }

}
