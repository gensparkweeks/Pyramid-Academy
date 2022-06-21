import java.util.Scanner;

public class Project3 {

    public static void main(String[] args) {

        solution();
    }

    public static String whatDragonIs(){

        return "Hungry";
    }
    public static String solution(){

        String result = "No option";

        Scanner input = new Scanner(System.in);
        int option = 3;

        System.out.println("        -------Is time to Play----------  ");
        System.out.println("You are in a land full of dragons. In front of you");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight");

        while (option != 0){

            System.out.println("");
            System.out.println( "\033[0;1m" + "What cave will you go into? (1 or 2) 0 to Exit ");

            try{
                option = Integer.parseInt(input.next());
            }catch (Exception e){
                System.out.println("Sorry, it is not a number...");
                System.out.println("Error message: " + e.getMessage());
                return "Exception Caught: Number Format Exception.";
            }

            switch (option){
                case 1:{
                    System.out.println("You approach the cave...");
                    System.out.println("It is dark and spooky...");
                    System.out.println("A large dragon jumps out in from of you! He opens his jaws and... ");
                    System.out.println("Gobbles you down in one bite!");
                    result = "Option 1";
                    break;
                }

                case 2:{
                    System.out.println("These dragons are friendly and will share their treasure with you...");
                    result = "Option 2";
                    break;

                }
            }
        }
        System.out.println("You are exit...");

        return result;
    }
}
