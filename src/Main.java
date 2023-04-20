import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner read;
    static Manager manager = new Manager();
    static Game game = new Game();

    static int soundOnOff = 0;

    public static void main(String[] args)
            throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        while (true) {
            printMenu();
            manager.readWordsFile();
            read = new Scanner(System.in);

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
                    break;
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
                    soundOnOff = 1;
                    System.out.println("Музыкааааа нас связалаааааа!");
                    break;
                case 5:
                    return;
                default :
                    System.out.println("Неа, нет такой команды!");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nДавай сыграем в Виселицу!\nЖмакни номер команды: \n" +
                "1 - Сыграть в игру\n2 - Добавить новые слова \n" +
                "3 - Как вообще играть?\n4 - Улучшить игру");
    }

    static void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if(soundOnOff == 0) {
            File f = new File("./" + "resources/8bit.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
    }

}