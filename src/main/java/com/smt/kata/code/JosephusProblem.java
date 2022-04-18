package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: JosephusProblem.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description:</b> 
 * The Josephus problem (or Josephus permutation) is a theoretical problem related 
 * to a certain counting-out game. The problem is described as below. People 
 * are standing in a circle waiting to be executed. Counting begins at a specified 
 * point in the circle and proceeds around the circle in a specified direction. 
 * After a specified number of people are skipped, the next person is executed. 
 * The procedure is repeated with the remaining people, starting with the next 
 * person, going in the same direction and skipping the same number of people, 
 * until only one person remains, and is freed.
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class JosephusProblem {

	int[] finalArr;
	/**
	 * The position returned by josephus(n - 1, k) is adjusted because the recursive
	 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
	 * @param numSoldiers Number of soldiers in the circle
	 * @param interval interval to remove them
	 * @return
	 */
	public int josephusRecursive(int numSoldiers, int interval) {
		int[] arr = new int[numSoldiers];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		findLast(numSoldiers, interval, interval%numSoldiers, arr);
		int index = 0;
		System.out.println("Final Arr");
		for (int i = 0; i < finalArr.length; i++) {
			System.out.print(finalArr[i]);
			if (finalArr[i] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void findLast (int numSoldiers, int interval, int index, int[] arr) {
		if (numSoldiers == 1) {
			finalArr = arr;
			return;
		}
		int[] newArr = new int[arr.length];
		System.out.println(" ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			newArr[i] = arr[i];
		}
		int count = 0;
		int curIndex = index;
		while (count < interval) {
			if (arr[curIndex] == 1) {
				++count;
			} 
			if (curIndex >= arr.length - 1) {
				curIndex = 0;
			} else {
				++curIndex;
			}
			
		}
		while (newArr[curIndex] != 1) {
			if (curIndex >= arr.length - 1) {
				curIndex = 0;
			} else {
				++curIndex;
			}
		}
		newArr[curIndex] = 0;
		findLast(numSoldiers - 1, interval, curIndex, newArr);
	}
}