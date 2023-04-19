// Program for validating all user inputs
//Michael Maseko
//11-04-2023

import javax.swing.*;


public class Validating {
    protected static boolean isValidInteger(Object input) {
        if (input instanceof String) {
            try {
                int value = Integer.parseInt((String) input);
                return value >= 0;
            } catch (NumberFormatException e) {
                // Ignore the exception, return false below
            }
        }
        return false;
    }

    protected static String validateVideo(String Video) {
        while (Video.isBlank() || Video.length() < 5|| !(Video.substring(Video.length() - 4, Video.length()).equals(".mpg"))) {
            JOptionPane.showMessageDialog(null,"Either the video is empty or it doesn't contain the extension \".mpg\", Please Try again!");
            Video = JOptionPane.showInputDialog(null, "Enter the video: (must have extension \".mpg\"");
        }
        return Video;
    }

    protected static String validateAccName(String AccName) {
        while (AccName.isBlank() || AccName.contains(" ")) {
            JOptionPane.showMessageDialog(null,"Account Name can't be blank and can't contain spaces in between!, Please try again!");
            AccName = JOptionPane.showInputDialog(null, "Enter the Account Name:");
            if (AccName == null){
                return null;
            }
        }
        return AccName;
    }

    protected static String validateTitle(String Title) {
        while (Title.isBlank()) {
            JOptionPane.showMessageDialog(null, "Title can't be blank!, Please try again!");
            Title = JOptionPane.showInputDialog(null, "Enter the Title:");
        }
        return Title;
    }

    protected static boolean validateLikes(Object Likes) {
        return isValidInteger(Likes);
    }

    protected static String validateDesc(String description) {
        while (description.isBlank()) {
            JOptionPane.showMessageDialog(null, "Description can't be blank!, Please try again!");
            description = JOptionPane.showInputDialog(null, "Enter the description:");
            if (description == null){
                return null;
            }
        }
        return description;
    }

    protected static boolean isAccExisting(Account account) {
        Node<Account> result = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, account);
        if (result == null) {
            return false;
        } else
            return true;
    }
    
}
