import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// This is inserted using vim command.
public class MyFrame extends JFrame {

    JButton button;
    JLabel label;

    MyFrame() {
        // creating a lebel
        label = new JLabel();
        label.setText("You have clicked the button.");
        label.setBounds(200, 150, 250, 100);
        label.setVisible(false);

        // creating a new jbutton
        button = new JButton("Button1");
        button.setBounds(200, 100, 100, 50);
        // using lambda expression to add a listener to the button
        button.addActionListener(e -> {
            System.out.println("Button 1 clicked!");
            button.setEnabled(false);
            button.setText("Clicked");
            label.setVisible(true);
        });
        button.setFocusable(false);
        button.setFont(new Font("comic sans", Font.BOLD, 15));
        button.setForeground(Color.green);
        button.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

}

// ------------- 1 way to use Action Listener ------------------

// public class MyFrame extends JFrame implements ActionListener {

// JButton button;

// MyFrame() {
// // creating a new jbutton
// button = new JButton("Button1");
// button.setBounds(200, 100, 100, 50);
// button.addActionListener(this);

// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// this.setLayout(null);
// this.setSize(500, 500);
// this.setVisible(true);
// this.add(button);
// }

// @Override
// public void actionPerformed(ActionEvent e) {
// if (e.getSource() == button) {
// System.out.println("Button 1 clicked");
// }
// }
// }
