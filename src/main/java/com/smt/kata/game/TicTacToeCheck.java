package com.smt.kata.game;

import java.util.List;
 import java.util.ArrayList;

import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: TicTacToeCheck.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Find Winner on a Tic Tac Toe Game
 * 
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 * 
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that 
 * the ith move will be played on grid[rowi][coli]. return the winner of the game 
 * if it exists (A or B). In case the game ends in a draw return "Draw". If there 
 * are still movements to play return "Pending".
 * 
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), 
 * the grid is initially empty, and A will play first.
 * 
 * Example 1:
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: A wins, they always play first.
 * https://assets.leetcode.com/uploads/2021/09/22/xo1-grid.jpg
 * 
 * Example 2:
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: B wins.
 * https://assets.leetcode.com/uploads/2021/09/22/xo2-grid.jpg
 * 
 * Example 3:
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 * https://assets.leetcode.com/uploads/2021/09/22/xo3-grid.jpg
 * 
 * Example 4:
 * Input: moves = [[0,0],[1,1]]
 * Output: "Pending"
 * Explanation: The game has not finished yet.
 * https://assets.leetcode.com/uploads/2021/09/22/xo4-grid.jpg
 * 
 * Constraints:
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= rowi, coli <= 2
 * 
 * There are no repeated elements on moves.
 * moves follow the rules of tic tac toe.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 26, 2021
 * @updates:
 ****************************************************************************/
public class TicTacToeCheck {
	
	private List<List<CoordinateVO>> winners;

	/**
	 * Identifies the players of the game
	 */
	public enum Player {
		A("PLayer One"), B("Player Two"), N("None");
		
		private String label;
		public String getLabel() { return label; }
		Player(String label) { this.label = label; }
	}
	
	public TicTacToeCheck() {
		winners = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			List<CoordinateVO> con = new ArrayList<>();
			con.add(new CoordinateVO(i, 0));
			con.add(new CoordinateVO(i, 1));
			con.add(new CoordinateVO(i, 2));
			winners.add(con);
			
			con = new ArrayList<>();
			con.add(new CoordinateVO(0, i));
			con.add(new CoordinateVO(1, i));
			con.add(new CoordinateVO(2, i));
			winners.add(con);
		}
		
		List<CoordinateVO> leftDiagonal = new ArrayList<>();
		leftDiagonal.add(new CoordinateVO(0, 0));
		leftDiagonal.add(new CoordinateVO(1, 1));
		leftDiagonal.add(new CoordinateVO(2, 2));
		winners.add(leftDiagonal);
		
		List<CoordinateVO> rightDiagonal = new ArrayList<>();
		rightDiagonal.add(new CoordinateVO(0, 2));
		rightDiagonal.add(new CoordinateVO(1, 1));
		rightDiagonal.add(new CoordinateVO(2, 0));
		winners.add(rightDiagonal);
	}

	/**
	 * Evaluates a Tic-Tac-Toe board based upon the moves provided
	 * @param moves Moves that were made by each player
	 * @return Player A or B if a player won.  Player N if no winner
	 */
	public Player evaluate(int[][] moves) {
		if (moves == null || moves.length == 0 || moves[0] == null || moves[0].length == 0) return  Player.N;
		
		List<CoordinateVO> listA = new ArrayList<>();
		List<CoordinateVO> listB = new ArrayList<>();
		boolean playerA = true;
		for (int[] move : moves) {
			CoordinateVO coord = new CoordinateVO(move[0], move[1]);
			if (playerA) {
				listA.add(coord);
				playerA = false;
			} else {
				listB.add(coord);
				playerA = true;
			}
		}
		if (checkWin(listA)) {
			return Player.A;
		} else if (checkWin(listB)) {
			return Player.B;
		} else {
			return Player.N;
		}
	}
	
	private boolean checkWin(List<CoordinateVO> moves) {
		
		for (List<CoordinateVO> winCon: winners) {
			boolean winner = true;
			for (CoordinateVO c : winCon) {
				if (!moves.contains(c)) {
					winner = false;
					break;
				}
			}
			if (winner) return true;
		}
		
		return false;
	}

}
