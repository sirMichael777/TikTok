// Program for validating all user inputs
//Michael Maseko
//11-04-2023

import javax.swing.*;
public class Validating {
    protected static boolean checkAccValidity (String input) {
        if (!input.contains(" ") || input.isBlank()){return false;}
        else{return true;}
    }
