import javax.swing.*;
import java.awt.*;
public class Menu extends JFrame {

    public Menu () {
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(325, 300);
        //setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);
        JLabel label = new JLabel("Choose an action from the menu:");
        label.setBackground(Color.red);
        panel.add(label);

        ButtonGroup group = new ButtonGroup();

        JRadioButton option1 = new JRadioButton("Find the profile description for a given account");
        option1.setBackground(Color.blue);
        group.add(option1);
        panel.add(option1);

        JRadioButton option2 = new JRadioButton("List all accounts");
        option2.setBackground(Color.MAGENTA);
        group.add(option2);
        panel.add(option2);

        JRadioButton option3 = new JRadioButton("Create an account");
        option3.setBackground(Color.green);
        group.add(option3);
        panel.add(option3);

        JRadioButton option4 = new JRadioButton("Delete an account");
        option4.setBackground(Color.red);
        group.add(option4);
        panel.add(option4);

        JRadioButton option5 = new JRadioButton("Display all posts for a single account");
        option5.setBackground(Color.MAGENTA);
        group.add(option5);
        panel.add(option5);

        JRadioButton option6 = new JRadioButton("Add a new post for an account");
        option6.setBackground(Color.green);
        group.add(option6);
        panel.add(option6);

        JRadioButton option7 = new JRadioButton("Load a file of actions from a disk and process this");
        option7.setBackground(Color.blue);
        group.add(option7);
        panel.add(option7);

        JRadioButton option8 = new JRadioButton("Quit");
        option8.setBackground(Color.red);
        group.add(option8);
        panel.add(option8);
        JButton submitButton = new JButton("Proceed");
        submitButton.addActionListener(e -> {
            if (option1.isSelected()) {
                String AccName = JOptionPane.showInputDialog(null, "Enter the account name:");
                Validating.validateAccName(AccName);
                
                method1(AccName);
            } else if (option2.isSelected()) {
                method2(JOptionPane.showInputDialog(null, "Enter the account name:"));
            } else if (option3.isSelected()) {
                String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");

                String description = JOptionPane.showInputDialog(null, "Enter the Account description:");
                while (description.isBlank()){
                    JOptionPane.showMessageDialog(null, "Account description can't be empty! Try again!");
                    description = JOptionPane.showInputDialog(null, "Enter the Account description:");
                }
                method3(name, description);
            } else if (option4.isSelected()) {
                method4(JOptionPane.showInputDialog(null, "Enter the account name:"));
            } else if (option5.isSelected()) {
                method5(JOptionPane.showInputDialog(null, "Enter the account name:"));
            } else if (option6.isSelected()) {
                String AccName = JOptionPane.showInputDialog(null, "Enter the account name:");
                Validating.validateAccName(AccName);
                String Video = JOptionPane.showInputDialog(null, "Enter the video:");
                Validating.validateVideo(Video);
                String Title = JOptionPane.showInputDialog(null, "Enter the Title:");
                Validating.validateTitle(Video);
                Object Likes = JOptionPane.showInputDialog(null, "Enter the number of likes:");
                Validating.validateLikes(Likes);
                JOptionPane.showMessageDialog(null, "Post successfully Added.");
                method6(AccName,Video, Title, (Integer) Likes);
            } else if (option7.isSelected()) {
                method7(JOptionPane.showInputDialog(null, "Enter the file name:"));
            } else if (option8.isSelected()) {
                JOptionPane.showMessageDialog(null, "Bye!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Choose an action from the menu:.");
            }
        });
        panel.add(submitButton);

        add(panel);

        setVisible(true);
    }
    public void method1 (String input) {
  
    }
    public void method2 (String input) {
        
    }
    public void method3(String name, String surname) {
       
    }
    public void method4 (String input) {
        
    }
    public void method5 (String input) {
        
    }

    public void method6 (String AccName, String Video, String Title, int Likes) {

    }
    public void method7(String input) {
        
    }
}

