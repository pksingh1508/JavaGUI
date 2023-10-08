import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextBoxFrame extends JFrame implements ActionListener {

    // JTextField = A GUI textbox component that can be used to add, set, or get
    // text

    JButton button;
    JTextField textField;

    TextBoxFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        // some customization
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setBackground(Color.black);
        textField.setForeground(Color.green);
        textField.setCaretColor(Color.white);
        textField.setText("User Name");

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Welcome " + textField.getText());
        }
    }

}
