import java.awt.*;

public class Treasure extends Rectangle {

    Color color;

    Treasure(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
