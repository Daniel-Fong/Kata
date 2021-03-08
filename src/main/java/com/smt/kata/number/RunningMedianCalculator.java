package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: RunningMedianCalculator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compute the running median of a sequence of numbers. 
 * That is, given a stream of numbers, print out the median of the list so far 
 * on each new element.
 * 
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * 
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 25, 2021
 * @updates:
 ****************************************************************************/
public class RunningMedianCalculator {

	/**
	 * 
	 */
	public RunningMedianCalculator() {
		super();
	}
	
	/**
	 * Takes an array of integers and returns the running median value
	 * @param values
	 * @return
	 */
	public List<Double> getMedianValues(int[] values) {
		
		List<Double> medianValues = new ArrayList<>();
		if (values == null) {
			return medianValues;
		}
		for (int i = 0; i < values.length; i++) {
			int[] arr = new int[i + 1];
			for (int x = 0; x < i+1; x++) {
				arr[x] = values[x];
			}
			int temp = 0;
			for (int j = 0; j < arr.length; j++) {
				for(int k=1; k < (arr.length-j); k++){  
                    if(arr[k-1] > arr[k]){  
                        temp = arr[k-1];  
                        arr[k-1] = arr[k];  
                        arr[k] = temp;  
                    }  
                    
				}  
			}
			for (int y = 0; y<arr.length; y++) {
				System.out.println(arr[y]);
			}
			if (arr.length % 2 == 0) {
				int num1 = arr[arr.length/2 - 1];
				int num2 = arr[arr.length/2];
				medianValues.add((double) (num1 + num2)/2);
			}
			else {
				medianValues.add((double) arr[(int) Math.floor(arr.length/2)]);
			}
		}
		return medianValues;
	}

}
