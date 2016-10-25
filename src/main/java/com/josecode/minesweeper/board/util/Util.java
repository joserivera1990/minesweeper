package com.josecode.minesweeper.board.util;

import com.josecode.minesweeper.board.Cell;
import com.josecode.minesweeper.board.impl.EmptyCell;
import com.josecode.minesweeper.board.impl.MineCell;
import com.josecode.minesweeper.board.impl.TrackCell;

public final class Util {
    
	private Util() {
		throw new AssertionError("The class " + getClass() + " shouldn't be instantiated");
	}
	
	public static void fillMissingCells(Cell[][] board, int sizeBoard) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				if (board[i][j] == null) {
					int numberTrack = findNumberTrackForCell(i, j, board, sizeBoard);
					board[i][j] = numberTrack > 0 ? new TrackCell(numberTrack) : new EmptyCell();
				}
			}
		}
	}
	
	private static int findNumberTrackForCell(final int i, final int j, Cell[][] board, int sizeBoard) {
		int numberTrack = 0; 
		numberTrack = numberTrack + checkMineAround(i+1, j, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i-1, j, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i, j-1, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i, j+1, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i+1, j-1, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i+1, j+1, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i-1, j+1, board,sizeBoard);
		numberTrack = numberTrack + checkMineAround(i-1, j-1, board,sizeBoard);
		return numberTrack;
	}
	
	
	private static int checkMineAround(int i,int j,final Cell[][] board,int sizeBoard) {
		boolean isValid = cellInsideBroad(i,j,sizeBoard) ? true : false; 
		if (isValid && board[i][j] != null && board[i][j] instanceof MineCell) {
			return 1;
		}
		return 0;
	}
	
	public static boolean cellInsideBroad(int x, int y, int sizeBoard) {
		return (x >= 0 && x < sizeBoard) && (y >= 0 && y < sizeBoard);
	}
	
	public static String createNumbersRow(final int size) {
		StringBuilder builder = new StringBuilder();
		builder.append(' ');
		for (int n = 0; n < size; ++n) {
			builder.append((char)(n + '1'));
		}
		return builder.toString();
	}
	
	public static String row(final int row, final Cell[][] grid) {
		StringBuilder builder = new StringBuilder();
		builder.append(row);
		for (int i = 0; i < grid.length; ++i) {
			builder.append(grid[row - 1][i]);
		}
		return builder.toString();
	}
	
	public static String row(final int size) {
		StringBuilder builder = new StringBuilder();
		for (int n = 0; n < size; ++n) {
			builder.append('-');
		}
		return builder.toString();
	}
	
}
