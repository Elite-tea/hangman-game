import java.util.*;

public class Game {

    static Manager manager = new Manager();

    static Random generator = new Random();

    static List<String> letters = new ArrayList<>();

    static HashMap<Integer,String> guessedLetters = new HashMap<>();

    Hangman hangman = new Hangman();

    public void guessingALetter(Scanner read) {
        System.out.println("Начнём?\n");
        hangman.printHangmanZeroTry(); // печать пустой виселицы
        System.out.println("\nСлово: ");
        printingAWord();
        boolean found;
        int tries = 6; // пользователю дано шесть попыток
        int counterLetter = 0;

        while (true) {
            found = false;
            System.out.println("\nПодумай и введи букву, которая может быть в слове, начальные буквы могут повторяться");
            String letter = read.next(); // считываю букву, которая может быть в слове
            for (int i = 0; i < letters.size(); i++) {
                if (letters.get(i).equals(letter)) { // если есть буква в слове, то заполняется HashMap угаданных букв
                    guessedLetters.put(i, letter);
                    found = true;
                    counterLetter++; // инкрементируем счётчик букв в слове
                }
            }

            for (int i = 0; i < letters.size(); i++) {
                guessedLetters.putIfAbsent(i, "_"); // заполняем HashMap шаблоном пустых букв
            }

            System.out.println(guessedLetters.get(0) + guessedLetters.get(1) + guessedLetters.get(2) +
                    guessedLetters.get(3) + guessedLetters.get(4) + guessedLetters.get(5) +
                    guessedLetters.get(6) + guessedLetters.get(7)); // печать слова с шаблоном

            if (counterLetter == 6) { // проверка на выигрыш, если выиграл, печатается сообщение
                System.out.println("Сегодня вешать некого :)");
                break;
            } else {
                if (!found) {// Проверка ошибок. Если ошибся - печатается одна из стадий виселицы
                    tries--;

                    if (tries == 5) {
                        hangman.printHangmanFirstTry();
                    } else if (tries == 4) {
                        hangman.printHangmanSecondTry();
                    } else if (tries == 3) {
                        hangman.printHangmanThirdTry();
                    } else if (tries == 2) {
                        hangman.printHangmanForthTry();
                    } else if (tries == 1) {
                        hangman.printHangmanFifthTry();
                    } else { // проигрыш, игра окончена
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

            for (int i = 0; i < randomWord.length(); i++) { // разбиваю случайное слово по буквам
                char letter = randomWord.charAt(i);
                letters.add(String.valueOf(letter));
            }

        String first = letters.get(0); // по задумке печатается элемент под нулевым и пятым индексами
        String fourth = letters.get(5); // в дальнейшем планирую исправить, чтоб буквы тоже печатались рандомные
        guessedLetters.put(0,letters.get(0));
        guessedLetters.put(5,letters.get(5));

        // печатаю слово для того, чтоб пользователь начинал угадывать буквы
        System.out.println(first + "_____" + fourth + "__");
    }

}