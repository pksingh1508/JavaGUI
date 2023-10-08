import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DropDownFrame extends JFrame implements ActionListener {
    JComboBox comboBox;

    DropDownFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = { "Dog", "Cat", "Bird" };
        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);
        comboBox.addItem("animals");
        comboBox.insertItemAt("Pig", 0);
        comboBox.setSelectedIndex(0);

        this.add(comboBox);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
            // System.out.println(comboBox.getSelectedIndex());
        }
    }

}
