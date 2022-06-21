import java.util.Scanner;

public class Project4 {

    public static void main(String[] args) {

        solution();
    }

    public static String guestName(){

        return "Bryan";
    }

    public static String solution(){

        String result = "";

        boolean didIt = false;
        int guessCount = 0;
        int guessTry = 0;
        int secretNumber = (int)(Math.random() * 20);
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! What's your name? ");
        String name = input.next();
        System.out.println("Welcome, "+ name+", I am thinking of a number between 1 and 20.");

        do{
            System.out.println( "\033[0;1m" + "Take a guess. ");
            try{
                guessTry = Integer.parseInt(input.next());
            }catch (Exception e){
                System.out.println("It wasn't a number!!!");
                System.out.println("Error message: " + e.getMessage());
                return "Exception Caught: Number Format Exception";
            }
            guessCount++;

            if (guessTry == secretNumber){
                System.out.println("Good job, "+ name+ "! You guessed my number in "+ guessCount+ " guesses");
                didIt = true;
                result = "Good";
            }else if( guessTry > secretNumber){
                System.out.println("Your guess is too high.");
            }else System.out.println("Your guess is too low.");

        }while (guessCount < 6 && !didIt);

        if (!didIt) {
            System.out.println("Please, try it again!");
            result = "Bad";
        }

        return result;
    }
}
