import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) {

        solution();
    }

    public static String solution(){

        boolean didIt = false;
        int guessCount = 0;
        int guessTry = 0;
        int secretNumber = (int)(Math.random() * 20);
        Scanner input = new Scanner(System.in);

        System.out.print("Hello! What's your name? ");
        String name = input.next();
        System.out.println("Welcome, "+ name+", I am thinking of a number between 1 and 20 in six tries.");

        do{
            boolean valid = false;
            while (!valid){
                try{
                    System.out.println( "\033[0;1m" + "Take a guess: ");
                    guessTry = Integer.parseInt(input.next());
                    valid = true;
                }catch (Exception e){
                    System.out.println("It wasn't a number!!!");
                }
            }

            guessCount++;

            if (guessTry == secretNumber){
                System.out.println("Good job, "+ name+ "! You guessed my number in "+ guessCount+ " guesses");

                didIt = true;
            }else if( guessTry > secretNumber){
                System.out.println("Your guess is too high.");
            }else System.out.println("Your guess is too low.");

        }while (guessCount < 6 && !didIt);

        if (!didIt) System.out.println("Please, try it again!");

        return null;
    }
}
