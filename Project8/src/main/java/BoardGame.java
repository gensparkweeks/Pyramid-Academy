import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
public class BoardGame extends JPanel implements KeyListener{
    private final int DIAMETER = 40;
    Human human = new Human (0, 0);
    Goblin goblin1 = new Goblin(50, 50);
    Goblin goblin2 = new Goblin(250, 150);
    Goblin goblin3 = new Goblin(400, 450);
    Goblin goblin4 = new Goblin(480, 500);
    Goblin goblin5 = new Goblin(500, 250);
    Goblin goblin6 = new Goblin(545, 400);
    public BoardGame(){
        addKeyListener(this);
        setFocusable(true);

        setBackground(Color.BLACK);
        setSize(800, 600);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        draw(g2);
        update();
    }
    public void draw(Graphics2D g){
        g.setColor(Color.GREEN);
        g.fill(human.getHuman());
        g.setColor(Color.RED);
        g.fill(goblin1.getGoblin());
        g.fill(goblin2.getGoblin());
        g.fill(goblin3.getGoblin());
        g.fill(goblin4.getGoblin());
        g.fill(goblin5.getGoblin());
        g.fill(goblin6.getGoblin());
    }
    public void update(){
        human.moveHuman(getBounds());
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        human.setDy(0);
        human.setDx(0);

        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT){
            human.setDx(1);
            human.setDy(0);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT){
            human.setDx(-1);
            human.setDy(0);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP){
            human.setDy(-1);
            human.setDx(0);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN){
            human.setDy(1);
            human.setDx(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getExtendedKeyCode() == KeyEvent.VK_RIGHT){
            human.setDx(0);
            human.setDy(0);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_LEFT){
            human.setDx(0);
            human.setDy(0);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_UP){
            human.setDy(0);
            human.setDx(0);
        }
        if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN){
            human.setDy(0);
            human.setDx(0);
        }
    }
    public boolean collision() {
        boolean exists = false;

        if (human.getBounds().intersects(goblin1.getBounds())){
            exists = true;
        }
        if (human.getBounds().intersects(goblin2.getBounds())){
            exists = true;
        }
        if (human.getBounds().intersects(goblin3.getBounds())){
            exists = true;
        }
        if (human.getBounds().intersects(goblin4.getBounds())){
            exists = true;
        }
        if (human.getBounds().intersects(goblin5.getBounds())){
            exists = true;
        }
        if (human.getBounds().intersects(goblin6.getBounds())){
            exists = true;
        }
        return exists;
    }
    public Rectangle getBounds() {
        return new Rectangle(human.getX(),human.getY(), DIAMETER, DIAMETER);
    }



}
