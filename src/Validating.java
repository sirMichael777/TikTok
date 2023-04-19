
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Class for validating all user inputs
 * @author Michael Maseko
 */
public class Validating {
    /**
     * Method to check if an object is an instance of an integer or not and also checks if it is equal or greater thaan 0
     * @param object the object to be checked 
     * @return returns true if the object is and instance of Integer class and is greater or equals 0
     */
    protected static boolean isValidInteger(Object object) {
        if (object instanceof String) {
            try {
                int value = Integer.parseInt((String) object);
                return value >= 0;
            } catch (NumberFormatException e) {
                // Ignore the exception, return false below
            }
        }
        return false;
    }
    /**
     *  Method to check if a video is valid or not, it asks for a valid one until the user enters a valid one or press cancel
     * @param Video Video to be checked for validity
     * @return returns a valid Video once the user enters a valid video else returns null if the user selects cancel
     */
    protected static String validateVideo(String Video) {
        while (Video.isBlank() || Video.length() < 5|| !(Video.substring(Video.length() - 4, Video.length()).equals(".mpg"))) {
            JOptionPane.showMessageDialog(null,"Either the video is empty or it doesn't contain the extension \".mpg\", Please Try again!");
            Video = JOptionPane.showInputDialog(null, "Enter the video: (must have extension \".mpg\"");
            if (Video == null){
                return null;
            }
        }
        return Video;
    }
    /**
     * Method to check if the account NAME is valid or not, it asks for a valid one until the user enters a valid one or press cancel
     * @param AccName The username to be checked for validity
     * @return returns a valid NAME once the user enters a valid Name else returns null if the user selects cancel
     */
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
    /**
     * Method to check if the post Title is valid or not, it asks for a valid one until the user enters a valid one or press cancel
     * @param Title The title to be checked for validity
     * @return returns a valid Title once the user enters a valid title or null if the user selects cancel
     */
    protected static String validateTitle(String Title) {
        while (Title.isBlank()) {
            JOptionPane.showMessageDialog(null, "Title can't be blank!, Please try again!");
            Title = JOptionPane.showInputDialog(null, "Enter the Title:");
            if (Title == null){
                return null;
            }
        }
        return Title;
    }
    
    /**
     * Method to check if the account description is valid or not, it asks for a valid one until the user enters a valid one or press cancel
     * @param description The description to be checked for vakidation
     * @return returns a valid description or null if the user cancels in the middle 
     */
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
    /**
     * Method to check if an account is existing on Tok Tik or not
     * @param account The account to search existence for
     * @return Returns true if the account exists else it returns false
     */
    protected static boolean isAccExisting(Account account) {
        Node<Account> result = TokTikTree.AccountsTree.search(TokTikTree.AccountsTree.root, account);
        if (result == null) {
            return false;
        } else
            return true;
    }
    protected static String validateFile(String fileName) {
        while (fileName.isBlank() || fileName.length() < 5|| !(fileName.substring(fileName.length() - 4, fileName.length()).equals(".txt"))) {
            JOptionPane.showMessageDialog(null,"Either the file name is empty or it doesn't contain the extension \".txt\", Please Try again!");
            fileName = JOptionPane.showInputDialog(null, "Enter the filename: (must have extension \".txt\"");
            if (fileName == null){
                return null;
            }
        }
        return fileName;
    }
    
}
