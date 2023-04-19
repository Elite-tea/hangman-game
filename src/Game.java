import java.util.List;
import java.util.Random;

public class Game {

    static Manager manager = new Manager();
    static Random generator = new Random();
    static char[] letters; // попробовать вместо массива использовать лист String

    public void guessingALetter(char letter) {
        char[] localArray = new char[8];

        for (int i = 0; i < letters.length; i++) {
            if (letters.equals(letter)) {
                localArray[i] =
            }
        }
    }

    public void printingAWord() {
        List<String> localListOfWords = manager.getWordsList(); // создаю новый лист, чтоб сложить туда слова
        String randomWord = localListOfWords.get(generator.nextInt(localListOfWords.size()));
        // получаю рандомное слово из листа
        letters = randomWord.toCharArray(); // разбиваю рандомное слово по буквам
        char first = letters[0];
        char fourth = letters[5];
        // 0  1  2  3  4  5  6  7
        System.out.println(first + "_____" + fourth + "__");
        // печатаю слово для того, чтоб пользователь начинал угадывать буквы
    }

}
