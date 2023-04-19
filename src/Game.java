import java.util.List;
import java.util.Random;

public class Game {

    static Manager manager = new Manager();
    static Random generator = new Random();
    static List<Character> letters; // попробовать вместо массива использовать лист String

    public void guessingALetter(char letter) {
        for (Character searchedLetter : letters) {
            if (searchedLetter.equals(letter)) { // если есть буква в слове, она должна стоять
                // на месте вывода по определённому индексу, типо sout(__a__a)
            }
        }
    }

    public void printingAWord() {
        manager.readWordsFile(); // вызываю метод, чтоб при запуске игры считались слова из файла
        List<String> localListOfWords = manager.getWordsList(); // создаю новый лист, чтоб сложить туда слова
        String randomWord = localListOfWords.get(generator.nextInt(localListOfWords.size()));
        // получаю рандомное слово из листа
        // а л л е р г и я
        if (letters == null) {
            for (int i = 0; i < randomWord.length(); i++) {
                char letter = randomWord.charAt(i);
                letters.add(letter); // ЗДЕСЬ NULL POINTER EXCEPTION
            } // разбиваю рандомное слово по буквам
        }
        char first = (char) letters.indexOf(0);
        char fourth = (char) letters.indexOf(5);
        // 0  1  2  3  4  5  6  7
        System.out.println(first + "_____" + fourth + "__");
        // печатаю слово для того, чтоб пользователь начинал угадывать буквы
    }

}
