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
