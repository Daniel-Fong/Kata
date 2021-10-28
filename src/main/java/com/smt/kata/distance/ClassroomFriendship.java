package com.smt.kata.distance;

import java.util.ArrayList;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: ClassroomFriendship.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Classroom Friendship Kata
 * 
 * A classroom consists of N students, whose friendships can be represented in an 
 * adjacency list. For example, the following descibes a situation where 0 is 
 * friends with 1 and 2, 3 is friends with 6, and so on.
 * 
 * {0: [1, 2],
 *  1: [0, 5],
 *  2: [0],
 *  3: [6],
 *  4: [],
 *  5: [1],
 *  6: [3]} 
 * 
 * Each student can be placed in a friend group, which can be defined as the 
 * transitive closure of that student's friendship relations. In other words, 
 * this is the smallest set such that no student in the group has any friends 
 * outside this group. For the example above, the friend groups 
 * would be {0, 1, 2, 5}, {3, 6}, {4}.
 * 
 * Given a friendship list such as the one above, determine the number of 
 * friend groups in the class.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
public class ClassroomFriendship {

	List<Integer> list = new ArrayList<>();
	List<Integer> friendGroup = new ArrayList<>();
	/**
	 * Counts the groups of friends
	 * @param friends friend assignments
	 * @return count of the number of friend groups
	 */
	public int countGroups(Map<Integer, List<Integer>> friends) {
		if (friends == null || friends.size() == 0) return 0;
		int result = 0;
		int i = 0;
		while (i < friends.size()) {
			list.add(i);
			++i;
		}
		
		while (list.size() > 0) {
			findGroup(friends, list, friendGroup, list.get(0));
			for (int num : friendGroup) {
				if (list.indexOf(num) >=0) {
					list.remove(list.indexOf(num));
				}
			}
			friendGroup = new ArrayList<>();
			++result;
		}
		return result;
	}
	
	public void findGroup(Map<Integer, List<Integer>> friends, List<Integer> available, List<Integer> friendGroup, int start) {
		if (!friendGroup.contains(start)) {
			friendGroup.add(start);
			if (friends.get(start) != null) {
				for (int num : friends.get(start)) {
					friendGroup.add(num);
				}
			}
		} else if (friendGroup.size() == 0) {
			for (int num : friendGroup) {
				if (list.indexOf(num) >=0) {
					list.remove(list.indexOf(num));
				}
			}
			return;
		}
		for (int num : friendGroup) {
			if (friends.get(num) != null && friends.get(num).size() >= 0) {
				for (int friend : friends.get(num)) {
					if (friendGroup.contains(friend)) {
						continue;
					}else {
						friendGroup.add(num);
						findGroup(friends, available, friendGroup, num);
					}
				}
			}
		}
	}
}
