package com.smt.kata.tree;

import java.util.Collections;
import java.util.ArrayList;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: LongestTreePath.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Tree Path
 * Given a tree where each edge has a weight, compute the length of the longest path in the tree.
 * 
 * For example, given the following tree:
 *
 *	   a
 *	  /|\
 *	 b c d
 *	    / \
 *	   e   f
 *	  / \
 *	 g   h
 * 
 * and the weights: a-b: 3, a-c: 5, a-d: 8, d-e: 2, d-f: 4, e-g: 1, e-h: 1, the 
 * longest path would be c -> a -> d -> f, with a length of 17.
 *
 * The path does not have to pass through the root, and each node can have any amount of children.
 * Each node on the tree can only be used once.  This means that once you hit a leaf, the 
 * path is at the end, as you would have to backtrack and use the same node twice
 * 
 * The root path will always have a weight of 0.
 *
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 24, 2021
 * @updates:
 ****************************************************************************/
public class LongestTreePath {
	KataTree<Integer> tree;
	List<Integer> results = new ArrayList<>();
	/**
	 * Calculates the longest path for the assigned weights at each node
	 * @param nodes Collection of nodes to calculate against
	 * @return Sum of the weights from each node in the path
	 */
	public int caclculatePath(List<KataNode<Integer>> nodes) {
		KataNode<Integer> n = nodes.get(0);
		//System.out.println(n.getNodeId());
		nodes.remove(0);
		
		this.tree = new KataTree<Integer>(nodes, n);
		List<KataNode<Integer>> allNodes = tree.getPreOrderList();
		List<KataNode<Integer>> leaves = getLeaves(allNodes); 
		
		for (var v: leaves) {
//			List<String> traversed = new ArrayList<>() ; 
			countMax(v, true, 0, new ArrayList<>());
//			System.out.println("traved =" +traversed.toString());
		}
//		System.out.println(this.results.toString());
		
		return Collections.max(this.results);
	}
	
	private List<KataNode<Integer>> getLeaves(List<KataNode<Integer>> allNodes) {
		List<KataNode<Integer>> leaves = new ArrayList<>();
		for (KataNode<Integer> node: allNodes) {
			if (node.getChildren().isEmpty()) {
				leaves.add(node);
			}
		}
		return leaves;
	}
	
	private boolean contain(String nodeId,  List<String> traversed){
		for(String n : traversed)  {
			if (n.equals(nodeId)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private void countMax(KataNode<Integer> node, boolean first, Integer count, List<String> traversed) {
		if (node != null) {
			count += node.getData();
			traversed.add(node.getNodeId());
			if (first == false && node.getChildren().size() == 0) {
				System.out.println(traversed.toString());
				System.out.println(count);
				this.results.add(count);
			} else if (node.getParentId() != null && node.getChildren().size() > 0) {
				System.out.println("both");
				if (!contain(node.getParentId(), traversed)) {
					countMax(tree.find(node.getParentId()), false, count, traversed);
				}
				for (KataNode<Integer> child: node.getChildren()) {
					if (!contain(child.getParentId(), traversed)) {
						countMax(child, false, count, traversed);
					}
				}
			} else if (node.getChildren().size() > 0) {
				System.out.println("children");
				for (KataNode<Integer> child: node.getChildren()) {
					if (!contain(child.getParentId(), traversed)) {
						countMax(child, false, count, traversed);
					}
				}
			} else if (node.getParentId() != null) {
				System.out.println("parent");
				if (!contain(node.getParentId(), traversed)) {
					//System.out.println(node.getParent().getNodeId());
					countMax(tree.find(node.getParentId()), false, count, traversed);
				}
			}
		}
	}

}
