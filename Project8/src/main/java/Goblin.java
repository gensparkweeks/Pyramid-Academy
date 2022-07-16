import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Goblin {
    private int x, y;
    private final int WIDTH = 40, HIGH = 40;
    public Goblin(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Rectangle2D getGoblin(){
        return new Rectangle2D.Double(x, y, WIDTH, HIGH);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HIGH);
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
}
