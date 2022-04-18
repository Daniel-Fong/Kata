package com.smt.kata.html;

import java.util.ArrayList;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: BrowsingHistories.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Browsing Histories Kata
 * 
 * We have some historical clickstream data gathered from our site anonymously 
 * using cookies. The histories contain URLs that users have visited in chronological order.
 * 
 * Write a function that takes two users' browsing histories as input and returns 
 * the longest contiguous sequence of URLs that appear in both.
 * 
 * For example, given the following two users' histories:
 * 
 * user1 = ['/home', '/register', '/login', '/user', '/one', '/two']
 * user2 = ['/home', '/red', '/login', '/user', '/one', '/pink']
 * You should return the following:
 * 
 * ['/login', '/user', '/one']
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2022
 * @updates:
 ****************************************************************************/
public class BrowsingHistories {
	List<List<String>> user1List = new ArrayList<>();
	List<List<String>> user2List = new ArrayList<>();

	/**
	 * Finds the longest sequence in the users browser histories
	 * @param user1 User1 browser history
	 * @param user2 User2 browser history
	 * @return Longest set of matching paths
	 */
	public List<String> findLongest(List<String> user1, List<String> user2) {
		if (user1 == null || user2 == null || user1.size() == 0 || user2.size() == 0) return new ArrayList<>();
		findAll(user1, user1List);
		findAll(user2, user2List);
		int maxSize = 0;
		List<String> result = new ArrayList<>();
		for (List<String> first : user1List) {
			if (user2List.contains(first)) {
				if (first.size() > maxSize) {
					maxSize = first.size();
					result = first;
				}
			}
		}
		return result;
	}
	
	public void findAll(List<String> list, List<List<String>> target) {
		if (list.size() == 0) return;
		List<String> newList = new ArrayList<>();
		for (String str: list) {
			newList.add(str);
			List<String> temp = new ArrayList<>(newList);
			target.add(temp);
		}
		newList.remove(0);
		findAll(newList, target);
	}
}
