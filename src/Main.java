import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);
    static Manager manager = new Manager();
    static Game game = new Game();

    public static void main(String[] args) {

        while (true) {

            printMenu();
            manager.readWordsFile();
            int command = read.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Начнём?\nПодумай и введи букву, которая может быть в слове");
                    game.printingAWord();
                    char letter = read.next().charAt(0); // считываю букву, которая может быть в слове
                    game.guessingALetter(letter);
                    break; // Изолировал команду 1 от команды 2.
                case 2:
                    System.out.println("Введи слово:");
                    String word = read.next();
                    manager.addWord(word);
                    break;
                case 3:
                    manager.printHowToPlay();
                    break;
                case 4:
                    manager.printAnIDEA();
                    break;
                default :
                    System.out.println("Неа, нет такой команды!");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nДавай сыграем в Виселицу!\nЖмакни номер команды:");
        System.out.println("\n1 - Сыграть в игру\n2 - Добавить новые слова");
        System.out.println("3 - Как вообще играть?\n4 - Пустая команда");
    }
}