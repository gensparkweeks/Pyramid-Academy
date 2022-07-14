public class Human {

    private int health;
    private int strength;
    private String name;
    private int x;
    private int y;

    Human(int health, int strength, String name, int x, int y){
        this.health = health;
        this.strength = strength;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Human{" +
                "health=" + health +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}
