import java.util.Map;

public class Game {

    static Manager manager = new Manager();

    public void guessingALetter(char letter) {
        char word = 0;
        Map<String, Character> localMapOfWords = manager.getWordsMap(); // creating a new map to put there letters
        for (int i = 0; i < localMapOfWords.size(); i++) {
            word = localMapOfWords.get(i); // getting letters
        }
        if (localMapOfWords.containsValue(letter)) { // if there's a letter user input in a word
            System.out.println(""); // then I must print an index of the word like s____ay
        }
    }

}
