import java.util.Map;

public class Game {

    static Manager manager = new Manager();

    public void guessingALetter(char letter) {
        char word = 0;
        Map<String, Character> localMapOfWords = manager.getWordsMap(); // создаю новую мапу, чтоб сложить туда слова
        for (int i = 0; i < localMapOfWords.size(); i++) {
            word = localMapOfWords.get(i); // получаю буквы
        }
        if (localMapOfWords.containsValue(letter)) { // если есть буква в слове, то заходим в метод
            System.out.println(""); // затем должна быть печать буквы в формате с__а_а, с получением буквы по индексу
        }
    }

}
