import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner read;
    static Manager manager = new Manager();
    static Game game = new Game();

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        while (true) {
            read = new Scanner(System.in);
            printMenu();
            manager.readWordsFile();
            int command;

            try {
                command = read.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Повтори");
                continue;
            }

            switch (command) {
                case 1:
                    game.guessingALetter(read);
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
                    playSound();
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
        System.out.println("3 - Как вообще играть?\n4 - Улучшить игру");
    }

    static void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File f = new File("./" + "resources/8bit.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
}