import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Menu class for displaying a menu GUI and interacts with the user
 * @author Michael Maseko
 */
public class Menu extends JFrame {
    /**
     * Constructor for creating a Menu GUI
     */
    public Menu () {
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 270);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.white);
        JLabel label = new JLabel("Choose an action from the menu:");
        label.setBackground(Color.red);
        panel.add(label);

        ButtonGroup group = new ButtonGroup();

        JRadioButton option1 = new JRadioButton("Find the profile description for a given account");
        option1.setBackground(Color.green);
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
        option7.setBackground(Color.magenta);
        group.add(option7);
        panel.add(option7);

        JRadioButton option8 = new JRadioButton("Quit");
        option8.setBackground(Color.red);
        group.add(option8);
        panel.add(option8);
        JButton submitButton = new JButton("Proceed");
        submitButton.setBackground(Color.decode("#FFFFFF"));
        submitButton.addActionListener(e -> {
            if (option1.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, We would appreciate it if you become our first user.");
                }else{
                    String AccName = JOptionPane.showInputDialog(null, "Enter the account name:");
                    while (AccName!= null){
                        AccName = Validating.validateAccName(AccName);
                        if (AccName!= null){
                            Account tempAccount = new Account(AccName);
                            while (!Validating.isAccExisting(tempAccount)){
                                if (AccName == null){
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, "The account you are looking for doesn't exist");  
                                AccName = JOptionPane.showInputDialog(null, "Enter the account name:"); 
                                if (AccName != null){
                                    AccName = Validating.validateAccName(AccName);
                                }else {
                                    break;
                                }
                            }
                        }
                    if (AccName != null){
                        findDesc(AccName);
                        break;
                    }     
                    }
                }

            } else if (option2.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, We would appreciate it if you become our first user.");
                }
                else{
                    String allAccounts = TokTikTree.AccountsTree.inorderTraversal(TokTikTree.AccountsTree.root);
                    if (TokTikTree.AccountsTree.treeSize(TokTikTree.AccountsTree.root) <= 40){
                        JOptionPane.showMessageDialog(null,"The available accounts are :\n" + allAccounts);
                    }else{
                        JOptionPane.showMessageDialog(null,"Your computer might not be able to handle this size, kindly check the output on the terminal");
                        System.out.println(allAccounts);
                    }
                }
            } else if (option3.isSelected()) {
                String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                if (name != null){
                    name = Validating.validateAccName(name);
                    if (name != null){
                        Random random = new Random();
                        String suggestion = name+ random.nextInt(1000);
                        while (Validating.isAccExisting(new Account(name))){
                            if (name == null){
                                break;
                            }
                            suggestion = name + random.nextInt(1000);
                            JOptionPane.showMessageDialog(null, "Sorry the username you want to use has been taken, you can try " + suggestion);       
                            name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                            if (name != null){
                                name = Validating.validateAccName(name);
                            } else{
                                break;
                            }
                        }
                        if (name != null){
                            String description = JOptionPane.showInputDialog(null, "Enter the Account description:");
                            if (description != null){
                                description = Validating.validateDesc(description);
                            }
                            if (name != null && description != null){
                                createAcc(name, description);
                            }
                        }
                    }
                }
            } else if (option4.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, We would appreciate it if you become our first user.");
                }
                else{
                    String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                    if (name != null){
                        name = Validating.validateAccName(name);
                        while (!Validating.isAccExisting(new Account(name))){
                            if (name == null){
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Sorry the Account you want to delete doesn't exist, try another account name.");  
                            name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                            if (name != null){
                                name = Validating.validateAccName(name);
                            }
                        }
                        if (name != null){
                            deleteAcc(name);
                        }
                        
                    }
                }

            } else if (option5.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, We would appreciate it if you become our first user.");
                }else{
                    String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                    while (name != null){
                        name = Validating.validateAccName(name);
                        if (name != null){
                            while (!Validating.isAccExisting(new Account(name))){
                                if (name == null){
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, "Sorry the Account you want to display posts for doesn't exist, try another account name.");
                                name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                                if (name != null){
                                    name = Validating.validateAccName(name);
                                }else{
                                    break;
                                }
                            }
                        }
                        if (name == null){
                            break;
                        }
                        Node<Account> account =TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, new Account(name));
                        if (account.data.Posts.size() == 0){
                            JOptionPane.showMessageDialog(null, "Sorry the Account you want to display posts for doesn't have posts");
                            break;
                        }else{
                            displayPosts(name, account.data.Posts);
                            break;
                        }
                    }
                }
            } else if (option6.isSelected()) {
                if (TokTikTree.AccountsTree.root == null){
                    JOptionPane.showMessageDialog(null, "There are no accounts yet!, We would appreciate it if you become our first user.");
                }else{
                    String name = JOptionPane.showInputDialog(null, "Enter the Account Name:");
                    if (name != null){
                        name = Validating.validateAccName(name);
                        if (name != null){
                        while (!Validating.isAccExisting(new Account(name))){
                            if (name == null){
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Sorry the Account you want to add posts for doesn't exist, try another account name.");
                            name =JOptionPane.showInputDialog(null, "Enter the Account Name:");
                            if (name != null){
                                name = Validating.validateAccName(name);
                            }
                        }if (name != null){
                            String video = JOptionPane.showInputDialog(null, "Enter the video: (must have extension \".mpg\"");
                            if (video != null){
                                video = Validating.validateVideo(video);
                                if (video != null){
                                    String Title = JOptionPane.showInputDialog(null, "Enter the Title:");
                                    if (Title != null){
                                        Title = Validating.validateTitle(Title);}
                                    if (name != null && video!= null && Title!= null){
                                        addPost(name, video, Title, "0");
                                }
                            }
                            }
                        }
                }
            }
        }
            } else if (option7.isSelected()) {
                String fileName = JOptionPane.showInputDialog(null, "Enter the file name:");
                while (fileName != null){
                    fileName = Validating.validateFile(fileName);
                    if (fileName == null){
                        break;
                    }
                    loadFile(fileName);
                    return;
                }
                    
                
       

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
    /**
     * Method called when the user wants to view the profile decription of a given account
     * @param AccName The name of the account that the user wants to view the profile description for
     */
    public void findDesc (String AccName) {
        Account tempAccount = new Account(AccName);
        Node<Account> result = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, tempAccount);
        JOptionPane.showMessageDialog(null, result.data.getDescription(tempAccount));
    }
    /**
     * Method to add a new user to TokTik
     * @param name The name they want to use as username and it's unique per user
     * @param description The profile description of the new user
     */
    public void createAcc(String name, String description) {
       TokTikTree.AccountsTree.insert(new Account(name, description));
       JOptionPane.showMessageDialog(null, "Account with username : " + name + " has been created successfully, welcome to TokTik.");
    }
    /**
     * Method for deleting a specific user Account
     * @param name The username of the account to be deleted
     */
    public void deleteAcc(String name) {
        TokTikTree.AccountsTree.delete(new Account(name));
        JOptionPane.showMessageDialog(null, "Account with username : " + name + " has been deleted successfully, we're saddened to see you leave, hoping to see you back soon.");
    }
    /**
     * Method to display posts for a single account
     * @param name The username of the account the user wants to display posts for
     * @param AccPosts The Stack containing all the posts of the specific user
     */
    public void displayPosts (String name, Stack<Post> AccPosts) {
        String result = "";
        if (AccPosts.size() == 0){
            JOptionPane.showMessageDialog(null, "Sorry there are no posts for this account.");
        }else{
            Stack<Post> copyAccPosts = AccPosts;
            while (copyAccPosts.size() != 0){
                result += copyAccPosts.pop().toString();
                result += "\n";
            }
            if (AccPosts.size() >= 40){
                JOptionPane.showMessageDialog(null, "This PC might not be able to handle such a large list, Please check the terminal for the results");
                System.out.println(result);
            }else{
                JOptionPane.showMessageDialog(null, result);
            }
            
        }
    }
    /**
     * Method for adding for a specific user
     * @param AccName The username of the user to addd a post for
     * @param Video Video of the post
     * @param Title The title or caption of the post
     * @param likes The number of likes the post have, it is 0 by default if its a new post
     */
    public void addPost (String AccName, String Video, String Title, String likes) {
        Node<Account> account = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, new Account(AccName));
        account.data.Posts.push(new Post(Video, Title, likes));
        JOptionPane.showMessageDialog(null, "Post for " + AccName + " Added successfuly!");
    }
    /**
     * Method to load a textFilefile and process nthe instructions on that file
     * @param fileName THe name of the file to be loaded
     */
    public void loadFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()){
            JOptionPane.showMessageDialog(null, "Sorry, the specified file name doesn't exist");
            return;
        }try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.equals("")){
                    String Action =line.substring(0,line.indexOf(" "));
                    line = line.replace(Action + " ", "");
                    String Account = line.substring(0,line.indexOf(" "));
                    line = line.replace(Account + " ", "");
                    if (Action.equals("Create")){
                        TokTikTree.AccountsTree.insert(new Account(Account,line));
                    }else{
                        String Video = line.substring(0,line.indexOf(" "));
                        line = line.replace(Video + " ", "");
                        String likes = line.substring(0,line.indexOf(" "));
                        String Title = line.replace(likes+ " ","");
                        Node<Account> account = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, new Account(Account));
                        account.data.Posts.push(new Post(Video, Title, likes));
                    } 
                }              
            }
            JOptionPane.showMessageDialog(null, "File loaded successfully");
            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Sorry, the specified file name doesn't exist");
            fileName = JOptionPane.showInputDialog(null, "Enter the file name:");
            while (fileName != null){
                fileName = Validating.validateFile(fileName);
                if (fileName == null){
                    break;
                }
            }
        }
    }
}



