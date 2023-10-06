import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Done with it.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setVisible(true);
        frame.setResizable(false);

        ImageIcon image = new ImageIcon("checklist.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.CYAN);

    }
}