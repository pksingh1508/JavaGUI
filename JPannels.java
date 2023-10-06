import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PanelExample {
    PanelExample() {
        JFrame f = new JFrame("Panel Example");

        JPanel panel = new JPanel();
        panel.setBounds(40, 80, 200, 200);
        panel.setBackground(Color.gray);

        JButton b1 = new JButton("Button 1");
        b1.setBounds(50, 100, 80, 30);
        b1.setBackground(Color.yellow);

        JButton b2 = new JButton("Button 2");
        b2.setBounds(100, 100, 80, 30);
        b2.setBackground(Color.green);

        panel.add(b1);
        panel.add(b2);

        f.add(panel);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}

public class JPannels {
    public static void main(String[] args) {
        // JPanel : a GUI component that function as a container to hold
        // other component

        // creating some label
        JLabel l1 = new JLabel();
        l1.setText("This is a Red box");

        // creating a JPanel for red color
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 130, 130);
        // Panel for green color
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(132, 0, 130, 130);
        // Panel for blue color
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(0, 131, 261, 130);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500, 500);

        redPanel.add(l1);

        frame.add(redPanel);
        frame.add(greenPanel);
        frame.add(bluePanel);

    }
}
