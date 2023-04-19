import java.util.*;

public class Game {

    static Manager manager = new Manager();
    static Random generator = new Random();
    static List<String> letters = new ArrayList<>(); // попробовать вместо массива использовать лист String
    static HashMap<Integer,String> guessedLetters = new HashMap<>();
    Hangman hangman = new Hangman();

    public void guessingALetter(Scanner read) {
        System.out.println("Начнём?\n");
        hangman.printHangmanZeroTry();
        System.out.println("\nСлово: ");
        printingAWord();
        boolean found;
        int counter = 6;
        int counterLetter = 0;

        while (true) {
            found = false;
            System.out.println("\nПодумай и введи букву, которая может быть в слове");
            String letter = read.next(); // считываю букву, которая может быть в слове
            for (int i = 0; i < letters.size(); i++) {
                if (letters.get(i).equals(letter)) { // если есть буква в слове, она должна стоять
                    guessedLetters.put(i, letter);// на месте вывода по определённому индексу, подобие sout(__a__a)
                    found = true;
                    counterLetter++;
                }
            }

            for (int i = 0; i < letters.size(); i++) {
                guessedLetters.putIfAbsent(i, "_"); // Заполняем hashmap шаблоном пустых букв
            }

            System.out.println(guessedLetters.get(0) + guessedLetters.get(1) + guessedLetters.get(2) +
                    guessedLetters.get(3) + guessedLetters.get(4) + guessedLetters.get(5) +
                    guessedLetters.get(6) + guessedLetters.get(7)); // Печать слова с шаблоном

            if (counterLetter == 6) { // Проверка на выигрыш, если выиграл, печатается сообщение
                System.out.println("Сегодня вешать некого :)");
                break;
            } else {
                if (!found) {// Проверка ошибок. Если ошибся - печатается одна из стадий виселицы
                    counter--;

                    if (counter == 5) {
                        hangman.printHangmanFirstTry();
                    } else if (counter == 4) {
                        hangman.printHangmanSecondTry();
                    } else if (counter == 3) {
                        hangman.printHangmanThirdTry();
                    } else if (counter == 2) {
                        hangman.printHangmanForthTry();
                    } else if (counter == 1) {
                        hangman.printHangmanFifthTry();
                    } else { // Проигрыш, игра окончена
                        hangman.printHangmanSixthTry();
                        break;
                    }
                }
            }
        }
        }

    public void printingAWord() {
        manager.readWordsFile(); // вызываю метод, чтоб при запуске игры считались слова из файла
        List<String> localListOfWords = manager.getWordsList(); // создаю новый лист, чтоб сложить туда слова
        // получаю случайное слово из листа
        String randomWord = localListOfWords.get(generator.nextInt(localListOfWords.size()));

            for (int i = 0; i < randomWord.length(); i++) {
                char letter = randomWord.charAt(i);
                letters.add(String.valueOf(letter)); // ЗДЕСЬ NULL POINTER EXCEPTION
            } // разбиваю случайное слово по буквам

        String first = letters.get(0);
        String fourth = letters.get(5);
        guessedLetters.put(0,letters.get(0));
        guessedLetters.put(5,letters.get(5));

        // печатаю слово для того, чтоб пользователь начинал угадывать буквы
        System.out.println(first + "_____" + fourth + "__");
    }
}