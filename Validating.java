// Program for validating all user inputs
//Michael Maseko
//11-04-2023

import javax.swing.*;
public class Validating {
    protected static boolean checkAccValidity (String input) {
        if (!input.contains(" ") || input.isBlank()){return false;}
        else{return true;}
    }protected static boolean isValidInteger(Object input) {
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
    protected static void ValidateVideo(String Video){
	while (Video.isBlank() || Video.length() < 5 || !(Video.substring(Video.length() -4, Video.length()).equals(".mpg"))){
	JOptionPane.showMessageDialog(null, "Either the video is empty or it doesn't contain the exetension \".pmg\", Try again!");
	Video = JOptionPane.showInputDialog(null, "Enter the video:");}
    }protected static void validateAccName (String AccName) {
        while (AccName.isBlank()) {
            JOptionPane.showMessageDialog(null, "Account Name can't be blank!, Please try again!");
            AccName = JOptionPane.showInputDialog(null, "Enter the Account Name:");
        }
    }
   
}
