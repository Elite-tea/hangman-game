import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);
    static Manager manager = new Manager();
    static Game game = new Game();

    public static void main(String[] args) {

        while (true) {

            printMenu();
            int command = read.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Let's get started!\nEnter a letter that might be in a word");
                    char letter = read.next().charAt(0); // reading a first character user input

                case 2:
                    System.out.println("Enter a word:");
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
                    System.out.println("Wrong number!");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nLet's play a Hangman game!\nEnter a command number:");
        System.out.println("\n1 - Play a game\n2 - Update list of words");
        System.out.println("3 - How to play\n4 - Got an IDEA");
    }

}