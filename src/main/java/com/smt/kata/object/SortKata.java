package com.smt.kata.object;
import java.util.Comparator;
import com.smt.kata.util.HashCodeUtil;

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
public class SortKata implements Comparable<SortKata> {
	
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
	
	@Override
    public int compareTo(SortKata kata) {
        if(kata.id == null ) return 1;
        if(this.id == null ) return -1;
        return (Integer.parseInt(this.id) < Integer.parseInt(kata.id))? 1:-1;
    }
	
	public static class SortKataAgeComparator implements Comparator<SortKata> {
        @Override
        public int compare (SortKata s1, SortKata s2) {
            return Integer.compare(s1.getAge(), s2.getAge());
        }
    }
	
	public static class SortKataNameComparator implements Comparator<SortKata> {
        @Override
        public int compare (SortKata s1, SortKata s2) {
            if(s1.getName() == null) return -1;
            if (s2.getName() == null) return 1;
            return (s1.getName().toUpperCase().compareTo(s2.getName().toUpperCase()));
        }
    }
}




