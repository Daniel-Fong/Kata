package com.smt.kata.code;
/****************************************************************************
 * <b>Title:</b> Dog.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Daniel Fong
 * @version 3.x
 * @since May 2, 2022
 * <b>updates:</b>
 *  
 ****************************************************************************/
public class Dog extends Animal {
	public String bark;
	
	public Dog(String walk, String eat, String bark) {
		super(walk, eat);
		this.bark = bark;
	}
	
	public void makeNoise() {
		System.out.println("Woof");	
	}
	
	public static void testException(String[] arr) throws NullPointerException {
		try {
			for (String str : arr) {
				System.out.println(str);
			}
		} catch (NullPointerException e) {
			System.out.print(e);
		}
	}
	
	public static void main(String[] args) {
		Dog taro = new Dog("on short legs", "everything", "at bigger dogs");
		System.out.println(taro.toString());
		testException(null);
		testException(new String[1]);
		taro.makeNoise();
	}
	
}
