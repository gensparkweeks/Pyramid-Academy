import java.util.*;

public class Project6 {

    public static void main(String[] args) {
        // create a keyboard entry
        Scanner keyboard = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain){
            // create the init grid for GameBoard
            Land land = new Land();
            land.setInitGameBoard();

            // Print the Welcome Board Game
            land.printGameBoard(1);
            land.pressAnyKey();

            // Create a new Human
            //1 - Set the name
            boolean good = false;
            String name = "";
            while(!good){
                name = land.getString("Type your name, please? ");
                System.out.print(name + " is your name, is that correct? (y/n) ");
                String okay = keyboard.nextLine();
                if (okay.toUpperCase().charAt(0) == 'Y'){
                    good = true;
                }
            }
            //2-Set health, strength, x, y
            Human human = new Human(10, 5, name, land.getAnyRandom(10), land.getAnyRandom(10));

            // Create Goblins
            ArrayList<Goblin> goblin = new ArrayList<>();
            for (int i=0; i < 10; i++){
                goblin.add(new Goblin(land.getAnyRandom(8), land.getGoblinName(), land.getAnyRandom(10), land.getAnyRandom(10)));
            }
            // Create Treasures
            ArrayList<Treasure> treasure = new ArrayList<>();
            treasure.add(new Treasure(land.getAnyRandom(5), land.getTreasureName(), land.getAnyRandom(10), land.getAnyRandom(10)));

            boolean humanIsAlive = true;
            do {

                land.setGameBoard(human, goblin, treasure);
                // Make a move
                land.getStats(human, goblin, treasure);
                good = false;
                while(!good){
                    System.out.println("'n' -> move up, 's' -> move down, 'e' -> move left, 'w' -> move right");
                    name = land.getString("Please, make a valid move: ");
                    if ("sewn".contains(String.valueOf(name.toLowerCase().charAt(0)))){
                        good = true;
                    }
                }
                if (name.toLowerCase().charAt(0) == 'n' && human.getX() > 0){
                        human.setX(human.getX() - 1);
                }
                if (name.toLowerCase().charAt(0) == 's' && human.getX() < 9){
                    human.setX(human.getX() + 1);
                }
                if (name.toLowerCase().charAt(0) == 'e' && human.getY() > 0){
                    human.setY(human.getY() - 1);
                }
                if (name.toLowerCase().charAt(0) == 'w' && human.getY() < 9){
                    human.setY(human.getY() + 1);
                }
                //Check the move
                String[] collision = land.setHumanBoard(human, goblin, treasure);

                //Update and show GameBoard
                land.setGameBoard(human, goblin, treasure);
                land.getStats(human, goblin, treasure);

                switch (collision[0].charAt(0)) {
                    case '1': {
                        System.out.println(collision[1]);
                        if (human.getHealth() < 1) {
                            System.out.println("The Human has died..");
                            humanIsAlive = false;
                        }
                        break;
                    }
                    case '2': {
                        System.out.println(collision[1]);
                        break;
                    }

                }

                if ((Integer.parseInt(collision[0])) > 0){
                    land.pressAnyKey();
                }

                if (goblin.size() <= 0){
                    System.out.println("The Human win!...");
                    humanIsAlive = false;
                }

            }while (humanIsAlive);

            System.out.print("\nDo you want to play again?, (y/n): ");

            if (keyboard.nextLine().toUpperCase().charAt(0) == 'N'){
                playAgain = false;
            }
        }//end while playAgain

        System.out.println("Bye!");


    }// end of main
}

