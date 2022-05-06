package com.smt.kata.code;
/****************************************************************************
 * <b>Title:</b> Animal.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Daniel Fong
 * @version 3.x
 * @since May 4, 2022
 * <b>updates:</b>
 *  
 ****************************************************************************/
public class Animal {
	public String walk;
	public String eat;
	
	public Animal(String walk, String eat) {
		this.walk = walk;
		this.eat = eat;
	}
	
	public String toString() {
		return "This animal walks " + this.walk + " and eats " + this.eat; 
	}
	
	public static void main(String[] args) {
		Animal fuzzy = new Animal("on 4 legs", "blueberries");
		System.out.println(fuzzy.toString());
	}
}
