import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Human {
    private int x = 0, y = 0;
    private int dx = 0, dy = 0;
    private final int W_WIDTH=800, W_HIGH=600;

    private final int DIAMETER = 40;
    private final int WIDTH = 40, HIGH = 40;
    public Human(int x, int y){
        this.x = x;
        this.y = y;

        //window = new Window();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HIGH);
    }
    public Rectangle2D getHuman(){
        return new Rectangle2D.Double(x, y, WIDTH, HIGH);
    }

    public void moveHuman(Rectangle limits){

        if (x + dx < 0)
            dx = 1;
        if (x + dx + WIDTH > W_WIDTH - 12)
            dx = -1;
        if (y + dy < 0)
            dy = 1;
        if (y + dy + HIGH > W_HIGH - DIAMETER)
            dy = -1;
//            window.gameOver();
//        if (board.collision()){
//            dy = -1;
////            y = game.racquet.getTopY() - DIAMETER;
//        }

        x += dx;
        y += dy;

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


    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
