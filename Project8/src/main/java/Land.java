import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Land extends JFrame {

    Image image;
    Graphics graphics;
    Human human;
    Goblin goblin1;
    Goblin goblin2;
    Goblin goblin3;
    Goblin goblin4;
    Goblin goblin5;
    Goblin goblin6;
    Goblin goblin7;
    Goblin goblin8;
    Treasure treasure;
    boolean gameOver;
    final int DIAMETER = 40, W_WIDTH = 600, W_HEIGHT = 600;
    int x, y, goblinsDied = 0;
    boolean treasureKilled, gob1Killed, gob2Killed, gob3Killed, gob4Killed, gob5Killed, gob6Killed, gob7Killed, gob8Killed = false;
    Random random = new Random();

     Land(){
        human = new Human(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.GREEN);
        goblin1 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin2 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin3 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin4 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin5 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin6 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin7 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);
        goblin8 = new Goblin(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.RED);

        treasure = new Treasure(random.nextInt(W_WIDTH - DIAMETER), random.nextInt(W_HEIGHT - DIAMETER), DIAMETER, DIAMETER, Color.MAGENTA);

        gameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(W_WIDTH, W_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);

        this.addKeyListener(new LoadKey());
    }

    public void paint(Graphics g){

        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image, 0, 0, this);

        human.draw(g);

        if (!gob1Killed) goblin1.draw(g);
        if (!gob2Killed) goblin2.draw(g);
        if (!gob3Killed) goblin3.draw(g);
        if (!gob4Killed) goblin4.draw(g);
        if (!gob5Killed) goblin5.draw(g);
        if (!gob6Killed) goblin6.draw(g);
        if (!gob7Killed) goblin7.draw(g);
        if (!gob8Killed) goblin8.draw(g);

        if (!treasureKilled) treasure.draw(g);

        if (gameOver){
            g.setColor(Color.RED);
            g.setFont(new Font("MV Boli", Font.PLAIN, 45));
            g.drawString("GAME OVER!", 150, 100);

        }

        System.out.println("Goblins died: "+ this.goblinsDied);
    }

    public void checkCollision(){

        if (human.intersects(goblin1)){
            if (!gob1Killed) goblinsDied = goblinsDied + 1;
            this.gob1Killed = true;
        }
        if (human.intersects(goblin2)){
            if (!gob2Killed) goblinsDied = goblinsDied + 1;
            this.gob2Killed = true;
        }
        if (human.intersects(goblin3)){
            if (!gob3Killed) goblinsDied = goblinsDied + 1;
            this.gob3Killed = true;
        }
        if (human.intersects(goblin4)){
            if (!gob4Killed) goblinsDied = goblinsDied + 1;
            this.gob4Killed = true;
        }
        if (human.intersects(goblin5)){
            if (!gob5Killed) goblinsDied = goblinsDied + 1;
            this.gob5Killed = true;
        }
        if (human.intersects(goblin6)){
            if (!gob6Killed) goblinsDied = goblinsDied + 1;
            this.gob6Killed = true;
        }
        if (human.intersects(goblin7)){
            if (!gob7Killed) goblinsDied = goblinsDied + 1;
            this.gob7Killed = true;
        }
        if (human.intersects(goblin8)){
            if (!gob8Killed) goblinsDied = goblinsDied + 1;
            this.gob8Killed = true;
        }
        if (human.intersects(treasure)){
            this.treasureKilled = true;

        }

        if (gob1Killed && gob2Killed && gob3Killed && gob4Killed && gob5Killed && gob6Killed && gob7Killed && gob8Killed){
            gameOver = true;
        }
    }

    public class LoadKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            human.keyPressed(e);
            checkCollision();
            repaint();
        }
    }
}
