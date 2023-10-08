import javax.swing.JOptionPane;

public class DialogPrompt {
    public static void main(String[] args) {

        // JOptionPane = pop a standard dialog box that prompts users for a value
        // or inform them of something

        /*
         * 
         * JOptionPane.showMessageDialog(null, "This is some useless info",
         * "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);
         * 
         * JOptionPane.showMessageDialog(null, "This is some useless info",
         * "INFORMATION_MESSAGE",
         * JOptionPane.INFORMATION_MESSAGE);
         * 
         * JOptionPane.showMessageDialog(null, "This is some useless info",
         * "QUESTION_MESSAGE",
         * JOptionPane.QUESTION_MESSAGE);
         * 
         * JOptionPane.showMessageDialog(null, "This is some useless info",
         * "WARNING_MESSAGE",
         * JOptionPane.WARNING_MESSAGE);
         * 
         * JOptionPane.showMessageDialog(null, "This is some useless info",
         * "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
         * 
         */

        // JOptionPane.showConfirmDialog(null, "Bro, do you even code?", "Tell Me",
        // JOptionPane.YES_NO_CANCEL_OPTION);

        // String name = JOptionPane.showInputDialog("What is your name?");
        // System.out.println("Hello, " + name);

        String[] response = { "No, you awesome", "Thanks you!", "Blush!" };
        JOptionPane.showOptionDialog(null, "You are awesome?", "Secret message", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, response, 0);

    }
}
