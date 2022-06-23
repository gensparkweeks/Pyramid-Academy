import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {

        solution();
    }

    public static String solution(){

        Scanner input = new Scanner(System.in);
        int option = 3;

        System.out.println("You are in a land full of dragons. In front of you");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight");

        while (option != 0){
            System.out.println("");
            System.out.print( "\033[0;1m" + "What cave will you go into? (1 or 2) 0 to exit: ");

            try{
                option = Integer.parseInt(input.next());
            }catch (Exception e){
                System.out.println("You are exit...");
                return "Exception Caught: Number Format Exception.";
            }

            switch (option){
                case 1:{
                    System.out.println("\nYou approach the cave...");
                    System.out.println("It is dark and spooky...");
                    System.out.println("A large dragon jumps out in from of you! He opens his jaws and... ");
                    System.out.println("Gobbles you down in one bite!");
                    break;
                }

                case 2:{
                    System.out.println("\nThese dragons are friendly and will share their treasure with you...");
                    break;

                }
            }
        }
        System.out.println("You are exit...");

        return null;
    }
}
