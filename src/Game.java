import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game {

    static Manager manager = new Manager();
    static Random generator = new Random();
    static List<String> letters = new ArrayList<>(); // попробовать вместо массива использовать лист String
    static HashMap<Integer,String> guessedLetters = new HashMap<>();
    Hangman hangman = new Hangman();

    public void guessingALetter(String letter) {
        for (int i = 0; i < letters.size(); i++) {
            if (letters.equals(letter)) { // если есть буква в слове, она должна стоять // guessedLetters.get(n).equals(letter)
                // на месте вывода по определённому индексу, подобие sout(__a__a)
            }
        }
    }

//    @Override
//    public String toStringI(String ){
//
//    }

    public void printingAWord() {
        manager.readWordsFile(); // вызываю метод, чтоб при запуске игры считались слова из файла
        List<String> localListOfWords = manager.getWordsList(); // создаю новый лист, чтоб сложить туда слова
        String randomWord = localListOfWords.get(generator.nextInt(localListOfWords.size()));
        // получаю случайное слово из листа
            for (int i = 0; i < randomWord.length(); i++) {
                char letter = randomWord.charAt(i);
                letters.add(String.valueOf(letter)); // ЗДЕСЬ NULL POINTER EXCEPTION
            } // разбиваю случайное слово по буквам
        String first = letters.get(0);
        String fourth = letters.get(5);
        guessedLetters.put(0,letters.get(0));
        guessedLetters.put(5,letters.get(5));
        // 0  1  2  3  4  5  6  7
        System.out.println(first + "_____" + fourth + "__");
        // печатаю слово для того, чтоб пользователь начинал угадывать буквы
    }
}
