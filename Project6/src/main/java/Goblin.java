public class Goblin {

    private int strength;
    private String name;
    private int x;
    private int y;

    Goblin(int strength, String name, int x, int y){
        this.strength = strength;
        this.name = name;
        this.x = x;
        this.y = y;
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
        return "Goblin{" +
                "strength=" + strength +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
