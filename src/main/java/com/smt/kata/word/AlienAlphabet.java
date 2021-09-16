package com.smt.kata.word;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: AlienAlphabet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Alien Alphabet Kata
 * 
 * You come across a dictionary of sorted words in a language you've never seen 
 * before. Write a program that returns the correct order of letters in this language.
 * 
 * For example, given ['xww', 'wxyz', 'wxyw', 'ywx', 'ywz'], 
 * you should return ['x', 'z', 'w', 'y'].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 23, 2021
 * @updates:
 ****************************************************************************/
public class AlienAlphabet {

    /**
     * Finds the "Alien" alphabet in order
     * @param words List of words in the proper order
     * @return Order of the characters
     */
    public char[] alphabetize(String[] words) {
        if (words == null || words.length <2) return new char[0];

        List<Character> results = new ArrayList<>();
        
        for (int i=0; i<words.length;i++) {
            char first = words[i].charAt(0);
            if (!results.contains(first)) {
                results.add(first);
            }
        }

        for (int x = 0; x < words.length; x++) {
            for (int y = x+1; y < words.length; y++) {
                for (int z = 0; z < words[x].length() && z < words[y].length(); z++) {
                    if (words[x].charAt(z) == words[y].charAt(z)) continue;
                    checkOrder(results, words[x].charAt(z), words[y].charAt(z));
                    break;
                }
            }
        }
        char[] myCharArray = new char[results.size()];
        for(int i = 0; i < results.size(); i++) {
            myCharArray[i] = results.get(i);
        }
        
        return myCharArray;
    }
    
    private void checkOrder(List<Character> alpha, char cur, char check) {

        int curIndex = 0;
        if (!alpha.contains(cur)) {
            curIndex = alpha.size();
        }

        int checkIndex = 0;
        for  (int i=0; i<alpha.size(); i++) {
            if (check == alpha.get(i)) checkIndex = i;
            if (cur == alpha.get(i)) curIndex = i;
        }
        if (curIndex > checkIndex) {
            if (alpha.contains(cur))alpha.remove(curIndex);
            alpha.add(checkIndex, cur);
        }
        
        
        
    }
}