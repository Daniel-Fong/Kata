package com.smt.kata.data;

import static org.mockito.Mockito.verifyNoInteractions;

import java.util.ArrayList;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: LargestSubset.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Largest Subset Kata
 * 
 * Given a set of distinct positive integers, find the largest subset such that 
 * every pair of elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.
 * 
 * For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. 
 * Given [1, 3, 6, 24], return [1, 3, 6, 24].
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 27, 2022
 * @updates:
 ****************************************************************************/
public class LargestSubset {

	/**
	 * List of params to validate into matching modulus
	 * @param values Array of values
	 * @return Collection of values with all modulus 0
	 */
	public List<Integer> find(List<Integer> values) {
		if (values == null || values.size() <= 1) return new ArrayList<>();
		findSubsets(values);
		int longest = 0;
		List<List<Integer>> results = findSubsets(values);
		List<Integer> result = new ArrayList<>();
		for (List<Integer> list : results) {
			if (meetsConditions(list)) {
				if (list.size() > longest) {
					longest = list.size();
					result = list;
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> findSubsets(List<Integer> values) {
		List<List<Integer>> subsets = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) {
			for (int j = i + 2; j <= values.size(); j++) {
				subsets.add(values.subList(i, j));
			}
		}
		return subsets;
	}
	
	public boolean meetsConditions(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int first = list.get(i);
				int second = list.get(j);
				if (first % second != 0 && second % first != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
