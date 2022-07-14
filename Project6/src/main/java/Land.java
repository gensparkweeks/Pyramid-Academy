import java.util.*;

public class Land {

    HashMap<Integer, String[]> grid = new HashMap<>();

    Land(){

    }

    public void setInitGameBoard(){
        for (int i=0; i < 10; i++){
            grid.put(i, new String[]{" - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", "\n" });
        }
    }
    public void printGameBoard(int time){
        if (time == 1){
            System.out.println("\nWelcome!!! to Humans Verse Goblins Game\n");
        }else System.out.println("\n     Humans Verse Goblins\n");

        for(Map.Entry<Integer, String[]> elem : grid.entrySet()){
            for(String arr: elem.getValue()){
                System.out.print(arr);
            }
        }

        if (time == 1){
            System.out.println("Your goal is to move (n/s/e/w) around the map and kill the goblins. When you kill a Goblin, you could ");
            System.out.println("loose health as a random number between 1 and 2, and gain strength as a random maximum number equal to ");
            System.out.println("Goblin's strength. Chests will be able once you kill the first Goblin, and will contain treasures with ");
            System.out.println("health from 1 to 5. Human die if Goblin has greater health, and can not have more than 10 as a health. ");
            System.out.println("                      Good Luck !!!");
        }
    }

    public String[] setHumanBoard(Human human, ArrayList<Goblin> goblin, ArrayList<Treasure> treasure){
        String[] result = new String[2];
        String str = "";

        String collision = "0"; //1- for Goblin, 2- for Treasure
        int index = 0;

        for (int i=0; i < goblin.size(); i++){
            if (goblin.get(i).getX() == human.getX() && goblin.get(i).getY() == human.getY()){
                collision = "1";
                index = i;
            }
        }
        for (int i=0; i < treasure.size(); i++){
            if (treasure.get(i).getX() == human.getX() && treasure.get(i).getY() == human.getY()){
                collision = "2";
                index = i;
            }
        }

        switch (collision.charAt(0)){
            case '1':{
                human.setHealth(human.getHealth() - getAnyRandom(goblin.get(index).getStrength()));
                str = "***** The Human has killed "+goblin.get(index).getName()+"... *****";
                goblin.remove(index);
                break;
            }
            case '2':{
                str = "$$$$$ Human found the "+treasure.get(index).getName() +", and he got it $$$$$";
                if (human.getHealth() + treasure.get(index).getHealth() <= 10){
                    human.setHealth(human.getHealth() + treasure.get(index).getHealth());
                } else human.setHealth(10);
                treasure.remove(index);
                break;
            }
        }

        result[0] = collision;
        result[1] = str;

        return result;
    }

    public void setGameBoard(Human human, ArrayList<Goblin> goblin, ArrayList<Treasure> treasure){
        setInitGameBoard();
        for(Map.Entry<Integer, String[]> elem : grid.entrySet()){

            //Updating Goblin
            for(int g = 0; g < goblin.size(); g++) {
                if (goblin.get(g).getX() == elem.getKey()){
                    for (int y=0; y < elem.getValue().length - 1; y++){
                        if (goblin.get(g).getY() == y){
                            elem.getValue()[y] = " G ";
                        }
                    }
                }
            }

            //Updating Treasure
            for(int t = 0; t < treasure.size(); t++) {
                if (treasure.get(t).getX() == elem.getKey()){
                    for (int y=0; y < elem.getValue().length - 1; y++){
                        if (treasure.get(t).getY() == y){
                            elem.getValue()[y] = " $ ";
                        }
                    }
                }
            }

            // Updating Human on the BoardGame
            if (human.getX() == elem.getKey()){
                for (int i=0; i < elem.getValue().length - 1; i++){
                    if (human.getY() == i){
                        elem.getValue()[i] = " H ";
                    }
                }
            }

        }
        printGameBoard(2);
    }

    public void getStats(Human human, ArrayList<Goblin> goblin, ArrayList<Treasure> treasure){
        System.out.println(human.getName()+"'s health: "+ human.getHealth());
        System.out.println(human.getName()+"'s strength: "+ human.getStrength());
        System.out.println("Goblins: "+ goblin.size());
        System.out.println("Treasures: "+treasure.size());
    }

    public String getGoblinName(){
        String[] goblinNames = new String[]{"Chimoild Goblin", "Vreazguz Goblin", "Groird Globin", "Kraduz Goblin", "Traadverx Goblin", "Bliznac Goblin", "Garez Goblin", "Strerd Goblin", "Blakt Goblin", "Rirk Goblin", "Fimord Goblin"};
        Random random = new Random();
        int setRandom = random.nextInt(goblinNames.length);

        return goblinNames[setRandom];
    }

    public String getTreasureName(){
        String[] treasureNames = new String[]{"Dagger", "Sword", "Armor", "Poison", "Magic Potion"};
        Random random = new Random();
        int setRandom = random.nextInt(treasureNames.length);

        return treasureNames[setRandom];
    }

    public String getString(String str){
        Scanner keyboard = new Scanner(System.in);
        String name;
        System.out.print(str);
        name = keyboard.nextLine();

        return name;
    }

    public int getAnyRandom(int range){
        if (range < 0){
            range = 1;
        }
        Random random = new Random();
        int result = random.nextInt(range);

        return result;
    }

    public void pressAnyKey(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nPress any key to continue...");
        keyboard.nextLine();
    }
}
