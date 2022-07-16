import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
public class Project8 {
    public static void main(String[] args) {

        Window window = new Window();

        window.setVisible(true);  // make the window visible
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // close with click on close (X)

    }
}
