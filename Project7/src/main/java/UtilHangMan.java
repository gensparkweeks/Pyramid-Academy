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

    public void printHangedMan(int wrongCount){
        System.out.println("");
        System.out.println(" -------");
        System.out.println(" |     |");

        if (wrongCount >= 1){
            System.out.println(" O");
        }

        if (wrongCount >= 2){
            System.out.print("\\");
            if (wrongCount >= 3){
                System.out.println(" /");
            }else System.out.println(" ");
        }

        if (wrongCount >= 4){
            System.out.println(" |");
        }

        if (wrongCount >= 5){
            System.out.print("/");
            if (wrongCount >= 6){
                System.out.println(" \\");
            }else System.out.println(" ");
        }
    }


}
