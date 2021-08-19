package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Collections;
// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: IntersectingRectangles.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Intersecting Rectangles Kata
 * 
 * Given two rectangles on a 2D graph, return the list of of their intersecting 
 * coordinates. If the rectangles don't intersect, return empty List.
 * 
 * For example, given the following rectangles:
 * 
 * {
 * 		"top_left": (1, 4),
 * 		"dimensions": (3, 3) # width, height
 * }
 * 
 * and
 * 
 * {
 * 		"top_left": (0, 5),
 * 		"dimensions": (4, 3) # width, height
 * }
 * 
 * return List with 6 coordinates 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
public class IntersectingRectangles {
	
	/**
	 * Finds the overlap between 2 rectangles
	 * @param one Starting coordinate of the first rectangle
	 * @param width1 width of the first rectangle
	 * @param height1 height of the first rectangle
	 * @param two Starting coordinate of the first rectangle
	 * @param width2 width of the first rectangle
	 * @param height2 height of the first rectangle
	 * @return List of overlapping coordinates
	 */
	public List<Coord> getOverlap(Coord one, int width1,  int height1, Coord two, int width2, int height2) {
		List<Coord> results = new ArrayList<>();
		List<Coord> boxOne = getBox(one, width1, height1);
		List<Coord> boxTwo = getBox(two, width2, height2);
		
		for (int i = 0; i < boxOne.size(); i++) {
			System.out.println("one " + boxOne.get(i).top + "," + boxOne.get(i).left);
			if (boxTwo.contains(boxOne.get(i))) {
				results.add(boxOne.get(i));
			}
		}
		for (int j = 0; j < boxOne.size(); j++) {
			System.out.println("two " + boxTwo.get(j).top + "," + boxOne.get(j).left);
		}
		
		return results;
	}
	
	public List<Coord> getBox(Coord start, int width, int height) {
		List<Coord> results = new ArrayList<>();
		for (int i = 0; i < height; i ++) {
			for (int j = 0; j < width; j++) {
				Coord coordinate = new Coord();
				coordinate.top = start.top + i;
				coordinate.left = start.left + j;
				results.add(coordinate);
			}
		}
		return results;
	}
}

/**
 * Helper class to group the coordinates on the grid
 */
class Coord {
	int top = 0;
	int left = 0;
	
	/**
	 * Default constructor
	 */
	public Coord() {
		super();
	}
	
	/**
	 * Helper constructor
	 * @param top Top coordinate
	 * @param left Left coordinate
	 */
	public Coord(int top, int left) {
		this();
		this.top = top;
		this.left = left;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Coord)) return false;
		Coord c2 = (Coord)o;
		return (c2.left == this.left && c2.top == this.top);
	}
}

