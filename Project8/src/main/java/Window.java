import javax.swing.*;

public class Window extends JFrame {
    private final int WIDTH=800, HIGH=600;
    private BoardGame board;
    private MoveThread thread;
    public Window(){
        setTitle("Humans vs Goblins Redux");
        setSize(WIDTH, HIGH);
        setLocationRelativeTo(null);  // to center the Window
        setResizable(false);          // avoid change size

        board = new BoardGame();

        add(board);

        thread = new MoveThread(board);
        thread.start();
    }
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    @Override
    public String toString() {
        return "Window{" +
                "WIDTH=" + WIDTH +
                ", HIGH=" + HIGH +
                '}';
    }
}
