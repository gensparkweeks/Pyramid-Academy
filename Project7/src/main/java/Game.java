import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Game {

    public static void main(String[] args) throws FileNotFoundException {

        //Create a new instance of utilHngMan
        UtilHangMan util = new UtilHangMan();

        //Set the read of the file using Scanner
        Scanner scanner = new Scanner(new File("src/main/resources/letters.txt"));
        Scanner keyboard = new Scanner(System.in);
        int wrongCount = 0;
        ArrayList<String> letterLines = new ArrayList<>();

        //Creating the Array to read all letters
        while(scanner.hasNext()){
            letterLines.add(scanner.nextLine());
        }

        //Select the random word
        Random randWord = new Random();
        String word = letterLines.get(randWord.nextInt(letterLines.size()));

        //New Array List of Characters for guessing word
        ArrayList<Character> playerGuess = new ArrayList<>();

        // While the player guess the word || the player consume the 6 times
        while(true){
            util.printHangedMan(wrongCount);

            if (wrongCount >= 6){
                System.out.println("You lose!");
                System.out.println("The word was: "+ word);
                break;
            }
            util.printWordState(word, playerGuess);

            if (!util.getPlayerGuess(keyboard, word, playerGuess)){
                wrongCount++;
            };

            if (util.printWordState(word, playerGuess)){
                System.out.println("\nYou win!");
                break;
            }
            if (playerGuess.size() >= word.length() / 2){
                System.out.println("\nIt is possible you already got the word, type it: ");
                if (keyboard.nextLine().equals(word)){
                    System.out.println("\nYou win!");
                    break;
                }else System.out.println("Nope! continue guessing...");
            }
        }
    }
}
