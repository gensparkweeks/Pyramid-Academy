import java.util.Arrays;

public class Project5 {

    static String randomLetter = "";
    static String missedLetter = "";
    static String guessedLetter = ""; //StringBuilder newString
    static String readLetter = "";
    static boolean stop = false;

    public static void main(String[] args) {

        //Create an instance of UtilsProject5
        UtilsProject5 util = new UtilsProject5();

        // Choose a random letter
        randomLetter = util.getRandomLetter();

        // Print initial Hang Man Structure && initialize guessLetter with ____
        guessedLetter = util.printInitialHang(randomLetter, missedLetter);

        while(!stop){

            int count = 0;
            StringBuilder guessTmp = new StringBuilder(guessedLetter);

            while(!randomLetter.equals(String.valueOf(guessTmp)) && randomLetter.length() > missedLetter.length()){
                //&& count < randomLetter.length()

                readLetter = util.readLetter("Guess a letter: ");

                if (String.valueOf(guessTmp).contains(readLetter) || missedLetter.contains(readLetter)){
                    while (String.valueOf(guessTmp).contains(readLetter) || missedLetter.contains(readLetter)){
                        System.out.println(readLetter + " was already typed, please");
                        readLetter = util.readLetter("Guess a letter: ");
                    }
                }

                boolean missL = false;
                for(int i=0; i < randomLetter.length(); i++){
                    if (randomLetter.charAt(i) == readLetter.charAt(0)){
                        guessTmp.setCharAt(i, randomLetter.charAt(i));
                        missL = true;
                    }else if(guessTmp.charAt(i) != randomLetter.charAt(i)){
                        guessTmp.setCharAt(i, '_');
                    }
                }
                if (!missL) missedLetter+=readLetter.charAt(0);

                util.printHangMan(randomLetter, missedLetter, String.valueOf(guessTmp));

            }

            guessedLetter = String.valueOf(guessTmp);

            if (randomLetter.equals(guessedLetter) ){
                System.out.println("You Guess the letter!");
            }

            if (!randomLetter.equals(guessedLetter) && randomLetter.length() == missedLetter.length()){
                System.out.println("You did not guess it... The letter is: " + randomLetter);
            }

            readLetter = util.readLetter("Do you wan to play again? (yes or not) ");
            while (!readLetter.equals("y") && !readLetter.equals("n")){
                readLetter = util.readLetter("Do you wan to play again? (yes or not) ");
            }
            if(readLetter.equals("n")){
                stop = true;
            }else {
                //Choose a new random word
                randomLetter = util.getRandomLetter();
                missedLetter = "";

                // Print initial Hang Man Structure && initialize guessLetter with ____
                guessedLetter = util.printInitialHang(randomLetter, missedLetter);
            }
        }

        System.out.println("Bye!");

    }

}
