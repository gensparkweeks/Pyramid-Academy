import java.util.Scanner;

public class UtilsProject5 {


    public void printHangMan(String randomLetter, String missedLetter, String guessedLetter){

        String missletterTmp = missedLetter;
        while (randomLetter.length() > missletterTmp.length()){
            missletterTmp+=" ";
        }

        //Printing the body of hangman
        int len = randomLetter.length();
        System.out.println("+---+\n");
        for(int i=0; i < randomLetter.length(); i++){
            System.out.println(missletterTmp.charAt(i)+"   |\n");
        }

        //Printing the base of hangman
        for(int i=0; i < randomLetter.length(); i++){
            System.out.print("=");
        }

        //Printing miss letters
        System.out.println("\n\nMissed letters: "+ missedLetter);

        //Printing guessed letters
        System.out.println(guessedLetter);

    }

    public String getRandomLetter(){
        String letter;

        letter = this.setArrLetters()[(int)(Math.random() * 20)];

        return letter;
    }

    public String printInitialHang(String randomLetter, String missedLetter){

        String guessLetter="";
        int len = randomLetter.length();

        System.out.println("+---+\n");

        while(len > 0){
            System.out.println("    |\n");
            len--;
        }

        len = randomLetter.length();
        while(len > 0){
            System.out.print("=");
            len--;
        }

        System.out.println("\nMissed letters: "+ missedLetter+"\n");

        len = randomLetter.length();
        while(len > 0){
            System.out.print("_");
            guessLetter+="_";
            len--;
        }

        return guessLetter;
    }

    public String[] setArrLetters(){

        String letters[]={"book", "cat", "dog", "java", "class", "genspark", "pyramid",
                            "portfolio", "interview", "github", "gitkraken", "html", "javascript",
                            "spring", "react", "exception", "timesheet", "brainery", "discord", "you", "week"};
        return letters;
    }

    public String readLetter(String question){
        Scanner input = new Scanner(System.in);
        String chr = "";

        System.out.println("");
        while(!chr.matches("[a-z][A-Z]*")){
            System.out.print( "\033[0;1m" + question);
            chr = input.next().toLowerCase();

            if(!chr.matches("[a-z][A-Z]*")){
                System.out.println(chr+" is not a letter!, please");
            }
        }

        return chr;
    }


}
