package com.smt.kata.game;

import java.util.ArrayList;
import java.util.List;

import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: KingCheck.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> King Check
 * 
 * You are presented with an 8 by 8 matrix representing the positions of pieces 
 * on a chess board. The only pieces on the board are the black king and various 
 * white pieces. Given this matrix, determine whether the king is in check.
 * 
 * For details on how each piece moves, see here.
 * 
 * For example, given the following matrix:
 * 
 * { 'O','O','O','K','O','O','O','O' },
 * { 'O','O','O','O','O','O','O','O' },
 * { 'O','B','O','O','O','O','O','O' },
 * { 'O','O','O','O','O','O','P','O' },
 * { 'O','O','O','O','O','O','O','R' },
 * { 'O','O','N','O','O','O','O','O' },
 * { 'O','O','O','O','O','O','O','O' },
 * { 'O','O','O','O','O','Q','O','O' }
 * 
 * You should return True, since the bishop is attacking the king diagonally.
 * 
 * 'K' = King
 * 'Q' = Queen
 * 'P' = Pawn
 * 'B' = Bishop
 * 'R' = Rook
 * 'N' = Knight
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 6, 2021
 * @updates:
 ****************************************************************************/
public class KingCheck {
	char[][] board;
	
	/**
	 * Assigns the chess board to the class
	 * @param board Chess board
	 */
	public KingCheck(char[][] board) {
		this.board = board;
	}

	public boolean pawn(int y, int x) {
		return (y > 0 && ((x+1 < board[0].length && board[y-1][x+1] == 'K') || (x > 0 && board[y-1][x-1] == 'K')));
	}

	public boolean rook (int y, int x) {
		if (y > 0) {
			for (int i = y-1; i >= 0; i--) {
				char c = board[i][x];
				if (c != 'O') {
					if (c == 'K') return true;
					else break;
				} 
			}
		}
		if (y < board.length) {
			for (int i = y+1; i < board.length; i++) {
				char c = board[i][x];
				if (c != 'O') {
					if (c == 'K') return true;
					else break;
				} 
			}
		}
		if (x > 0) {
			for (int i = x-1; i >= 0; i--) {
				char c = board[y][i];
				if (c != 'O') {
					if (c == 'K') return true;
					else break;
				} 
			}
		}
		if (x < board[0].length) {
			for (int i = x+1; i < board[0].length; i++) {
				char c = board[y][i];
				if (c != 'O') {
					if (c == 'K') return true;
					else break;
				} 
			}
		}
			
		return false;
	}
	
	public boolean bishop(int baseY, int baseX) {
    	
		int y = baseY;
		int x = baseX;
    	// iterate up right
    	while(y > 0 && x < board[0].length - 1) {
	    	y--;
	    	x++;
	    	char c = board[y][x];
	    	if(c != 'O') {
          		if(c == 'K') return true;
				else break;
        	}
        
      	}
    	
    	//iterate up left
		y = baseY;
		x = baseX;
    	while(y > 0 && x > 0) {
	    	y--;
	    	x--;
	    	char c = board[y][x];
	    	if(c != 'O') {
          		if(c == 'K') return true;
				else break;
        	}
        
      	}
    	
    	// iterate down right
		y = baseY;
		x = baseX;
    	while(y < board.length-1 && x < board[0].length - 1) {
	    	y++;
	    	x++;
	    	char c = board[y][x];
	    	if(c != 'O') {
          		if(c == 'K') return true;
				else break;
        	}
        
      	}
    	// iterate down left
		y = baseY;
		x = baseX;
    	while(y < board.length - 1 && x > 0) {
	    	y++;
	    	x--;
	    	char c = board[y][x];
	    	if(c != 'O') {
          		if(c == 'K') return true;
				else break;
        	}
      	}
    	return false;
  }
	
	public boolean queen(int y, int x) {
		return rook(y,x) || bishop(y,x);
	}
	
	public boolean knight(int row, int col) {
		List<CoordinateVO> points = new ArrayList<>();
		points.add(new CoordinateVO(row+2, col+1));
		points.add(new CoordinateVO(row+2, col-1));
		points.add(new CoordinateVO(row-2, col+1));
		points.add(new CoordinateVO(row-2, col-1));
		points.add(new CoordinateVO(row-1, col-2));
		points.add(new CoordinateVO(row+1, col-2));
		points.add(new CoordinateVO(row+1, col+2));
		points.add(new CoordinateVO(row-1, col+2));
		
		for (CoordinateVO point : points) {
			if (point.getRow() < 0 || point.getRow() >= board.length ||
					point.getColumn() < 0 || point.getColumn() >= board[0].length)
				continue;
			
			if (board[point.getRow()][point.getColumn()] == 'K') return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param board
	 * @return
	 */
	public boolean isKingCheck() {
		
		if (board == null || board.length != 8 || board[0] == null || board[0].length != 8) return false;
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				char c = board[row][col];
				if (c == 'K' || c == 'O') continue;
				if (checkPeice(c, row, col)) return true;
			}
		}
		
		return false;
	}
	
	private boolean checkPeice (char piece, int row, int col) {
		switch (piece) {
			case 'P': return pawn(row, col);
			case 'B': return bishop(row, col);
			case 'R': return rook(row, col);
			case 'N': return knight(row, col);
			case 'Q': return queen(row, col);
			default: return false;
		}
	}
}
