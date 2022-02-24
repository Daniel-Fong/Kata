package com.smt.kata.data;

/****************************************************************************
 * <b>Title</b>: StrobogrammaticNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Strobogrammatic Number Kata
 * 
 * A strobogrammatic number is a positive number that appears the same after 
 * being rotated 180 degrees. For example, 16891 is strobogrammatic.
 * 
 * Create a program that finds all strobogrammatic numbers with N digits.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 22, 2022
 * @updates:
 ****************************************************************************/
public class StrobogrammaticNumber {
    
    /**
     * Determines if a number is strobomatic
     * @param source Number to evaluate
     * @return True if stobomatic.  False otherwise
     */
    public boolean isStrobogrammaticNumber(int source) {
        if (source < 0) return false;
        String str = Integer.toString(source);
        for (int i = 0; i < str.length() / 2; i++) {
            char char1 = str.charAt(i);
            char char2 = str.charAt(str.length() - 1 - i);
            System.out.println(char1);
            System.out.println(char2);
            if ((char1 != '8' && char1 != '0' && char1 != '1') || (char2 != '8' && char2 != '0' && char2 != '1') && (char1 != '6' && char2 != '9') && (char1 != '9' && char2 != '6')) {
                return false;
            } 
        }
        return true;
    }

}
