import java.util.ArrayList;
import java.util.Scanner;

public class UtilHangMan {

    public boolean printWordState(String word, ArrayList<Character> playerGuess){
        int correctCount = 0;
        for (int i=0; i < word.length(); i++){
            if (playerGuess.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount++;
            }else{
                System.out.print("-");
            }
        }

        return correctCount == word.length();
    }

    public boolean getPlayerGuess(Scanner keyboard, String word, ArrayList<Character> playerGuess){
        System.out.println("\nPlease, enter a letter: ");
        String letterGuess = keyboard.nextLine();
        playerGuess.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    public void printHangedMan(ArrayList<String> ListArts, int count){
        System.out.println("");
        for (int i = 0; i < count; i++){
            System.out.println(ListArts.get(i));
        }
        System.out.println("You have "+(ListArts.size() - count)+" try left.");
    }


}
