
// import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
// import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label {
    public static void main(String[] args) {
        // adding image
        // ImageIcon image = new ImageIcon("checklist.png"); // create the instance of
        // the image

        // Border
        Border border = BorderFactory.createLineBorder(Color.green, 3, true); // create a border instance

        // adding lebel in our frame
        JLabel label = new JLabel();
        // label.setIcon(image);
        label.setText("Hello how are you?");
        label.setText("Bro, do you know to code.");
        label.setForeground(Color.ORANGE); // set color of the text
        label.setFont(new Font("MV Boli", Font.PLAIN, 50)); // set font of the label
        label.setIconTextGap(-45); // set gap between image and text
        label.setBackground(Color.red); // set background color of the label
        label.setOpaque(true); // make background visible
        label.setBorder(border); // set border for the label
        label.setVerticalAlignment(JLabel.CENTER); // vertical alignment of the label
        label.setHorizontalAlignment(JLabel.CENTER); // horizontal alignment of the label
        label.setHorizontalTextPosition(JLabel.CENTER); // setting the text position of the label horizontally
        label.setVerticalTextPosition(JLabel.TOP); // setting the text position of the label vertically
        // label.setBounds(100, 100, 200, 200); // set the position of the label with
        // height and width

        // creating a jframe
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // jframe.setSize(600, 600);
        // jframe.setLayout(null); // makeing null when using setBounds method
        jframe.setVisible(true);
        jframe.setResizable(true);
        jframe.setTitle("This is a label");
        jframe.add(label); // for adding label to the frame
        jframe.pack(); // for pack all the label

        // changing the bg color
        // jframe.getContentPane().setBackground(Color.GRAY);
        jframe.getContentPane().setBackground(new Color(123, 50, 250)); // changing the color of the frame.

    }
}
