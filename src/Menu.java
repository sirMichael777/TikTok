import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
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
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, You can try creating accounts first.");
                }else{
                    String AccName = JOptionPane.showInputDialog(null, "Enter the account name:");
                    Account tempAccount = new Account(Validating.validateAccName(AccName));
                    while (!Validating.isAccExisting(tempAccount)){
                        if (AccName == null){
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "The account you are looking for doesn't exist");
                        AccName = JOptionPane.showInputDialog(null, "Enter the account name:");                          
                            tempAccount = new Account(AccName);{

                            }
                    }
                if (AccName != null){
                    method1(AccName);
                }     
                }
            } else if (option2.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, You can try creating accounts first.");
                }
                else{
                    String allAccounts = TokTikTree.AccountsTree.inorderTraversal(TokTikTree.AccountsTree.root);
                    JOptionPane.showMessageDialog(null,"The available accounts are :\n" + allAccounts);
                }
            } else if (option3.isSelected()) {
                String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                if (name != null){
                    while (Validating.isAccExisting(new Account(name))){
                        Random random = new Random();
                        String suggestion = name+ random.nextInt(1000);
                        while(Validating.isAccExisting(new Account(suggestion))){
                            suggestion = name + random.nextInt(2);
                        }
                        JOptionPane.showMessageDialog(null, "Sorry the username you want to use has been taken, you can try " + suggestion);       
                        name = Validating.validateAccName(JOptionPane.showInputDialog(null, "Enter the Account Name:"));
                    }

                    String description = JOptionPane.showInputDialog(null, "Enter the Account description:");
                    description = Validating.validateTitle(description);
                    method3(name, description);
                }
            } else if (option4.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, You can try creating accounts first.");
                }
                else{
                    String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                    name = Validating.validateAccName(name);
                    if (name != null){
                        while (!Validating.isAccExisting(new Account(name))){
                            JOptionPane.showMessageDialog(null, "Sorry the Account you want to delete doesn't exist, try another account name.");  
                            name = Validating.validateAccName(JOptionPane.showInputDialog(null, "Enter the Account Name:"));
                        }
                        method4(name);
                    }
                }

            } else if (option5.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, You can try creating accounts first.");
                }else{
                    String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                    if (name != null){
                        name = Validating.validateAccName(name);
                        while (!Validating.isAccExisting(new Account(name))){
                            if (name == null){
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Sorry the Account you want to display posts for doesn't exist, try another account name.");
                            name = Validating.validateAccName(JOptionPane.showInputDialog(null, "Enter the Account Name:"));
                        }
                        Node<Account> account =TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, new Account(name));
                        if (account.data.Posts.size() == 0){
                            JOptionPane.showMessageDialog(null, "Sorry the Account you want to display posts for doesn't have posts");
                        }else{
                            if (name != null){
                            method5(name,account.data.Posts);
                            }
                        }
                    }
                }
            } else if (option6.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, You can try creating accounts first.");
                }else{
                    String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                    
                    name = Validating.validateAccName(name);
                    while (!Validating.isAccExisting(new Account(name))){
                        if (name == null){
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Sorry the Account you want to add posts for doesn't exist, try another account name.");
                        name = Validating.validateAccName(JOptionPane.showInputDialog(null, "Enter the Account Name:"));
                    }
                    String video = JOptionPane.showInputDialog(null, "Enter the video: (must have extension \".mpg\"");
                    video = Validating.validateVideo(video);
                    String Title = JOptionPane.showInputDialog(null, "Enter the Title:");
                    Title = Validating.validateTitle(Title);
                    method6(name,video, Title, 0);
                }
            } else if (option7.isSelected()) {
                String filename = JOptionPane.showInputDialog(null, "Enter the file name:");
       

            } else if (option8.isSelected()) {
                JOptionPane.showMessageDialog(null, "Thank you for using the best social media platform, Bye!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Choose an action from the menu:");
            }
        });
        panel.add(submitButton);

        add(panel);

        setVisible(true);
    }
    public void method1 (String AccName) {
        Account tempAccount = new Account(AccName);
        Node<Account> result = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, tempAccount);
        JOptionPane.showMessageDialog(null, result.data.getDescription(tempAccount));
    }
    public void method3(String name, String description) {
       TokTikTree.AccountsTree.insert(new Account(name, description));
       JOptionPane.showMessageDialog(null, "Account with username : " + name + " has been created successfully, welcome to TokTik.");
    }
    public void method4 (String name) {
        TokTikTree.AccountsTree.delete(new Account(name));
        JOptionPane.showMessageDialog(null, "Account with username : " + name + " has been deleted successfully, we're saddened to see you leave, hoping to see you back soon.");
    }
    public void method5 (String name, Stack<Post> AccPosts) {
        String result = "";
        if (AccPosts.size() == 0){
            JOptionPane.showMessageDialog(null, "Sorry there are no posts for this account.");
        }else{
            Stack<Post> copyAccPosts = AccPosts;
            while (copyAccPosts.size() != 0){
                result += copyAccPosts.peek().toString();
                result += "\n";
            }
            JOptionPane.showMessageDialog(null, result);
        }
    }

    public void method6 (String AccName, String Video, String Title, int Likes) {
        Node<Account> account = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, new Account(AccName));
        account.data.Posts.push(new Post(Video, Title, Likes));
        JOptionPane.showMessageDialog(null, "Post for " + AccName + " Added successfuly!");
    }
    public void method7(String input) {

    }
}

