package com.smt.kata.object;

/****************************************************************************
 * <b>Title</b>: SortKata.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> This Kata focuses on Collection sorting and how it works.
 * Additional classes may need to be created.  Please use inner classes within
 * this class for any additional code requirements
 * You may utilize the HashCodeUtil class from this project if needed.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 7, 2021
 * @updates:
 ****************************************************************************/
public class SortKata {
	
	private String id;
	private String name;
	private int age;

	/**
	 * 
	 */
	public SortKata() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}




