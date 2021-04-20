package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: IPAddress.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Implement a class that receives two IPv4 addresses, 
 * and returns the number of addresses between them (including the first one, 
 * excluding the last one). All inputs will be valid IPv4 addresses in the form 
 * of strings. The last address will always be greater than the first one. 
 * Examples ips_between("10.0.0.0", "10.0.0.50")  ==   50 
 * ips_between("10.0.0.0", "10.0.1.0")   ==  256 
 * ips_between("20.0.0.10", "20.0.1.0")  ==  246
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 12, 2021
 * @updates:
 ****************************************************************************/
public class IPAddress {

	/**
	 * Initializes the class
	 */
	public IPAddress() {
		super();
	}

	/**
	 * Determines the number of hosts between the 2 ip's
	 * @param ipStart
	 * @param ipEnd
	 * @return
	 */
	public int numberHosts(String ipStart, String ipEnd) {

		int[] start = intArr(ipStart);
		int[] end = intArr(ipEnd);
		
		int diff = 0;
		
		for (int i = 0; i<start.length; i++) {
			int multiplier = (int) Math.pow(256, 3-i);
			diff += (start[i] - end[i]) * multiplier; 
		}
		
		return Math.abs(diff);
	}
	
	public int[] intArr(
			String str) {
		int[] arr = new int[4];
		String num = "";
		int counter = 0;
		for (int i=0; i<str.length(); i++) {
			if (i == str.length() - 1) {
				num += str.charAt(i);
				arr[counter] = Integer.parseInt(num);
			}
			else if (str.charAt(i) == '.') {
				arr[counter] = Integer.parseInt(num);
				System.out.println(num);
				num = "";
				counter ++;
			}
			else {
				num += str.charAt(i);
			}
		}
		return arr;
	}
}
