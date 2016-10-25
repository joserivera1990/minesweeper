package com.josecode.minesweeper.board.impl;

import com.josecode.minesweeper.board.Board;
import com.josecode.minesweeper.board.Cell;
import com.josecode.minesweeper.board.setup.InitialPositioningStrategy;
import com.josecode.minesweeper.board.util.Util;

public class SimpleBoard implements Board {
	
	Cell [][] grid;
    private boolean isWinner;
    private boolean isLost;
    
	public SimpleBoard(int size, int numberMines) {
		this.grid =  InitialPositioningStrategy.getInstance().createBoard(size, numberMines);
	}
	
	@Override
	public boolean won() {
		return isWinner;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Util.createNumbersRow(grid.length))
			   .append(String.format("%n"))
			   .append(Util.row(grid.length + 1))
			   .append(String.format("%n"));
		for (int i = 0; i < grid.length; ++i) {
			builder.append(Util.row(i + 1, grid))
			       .append(String.format("%n"));
		}
		return builder.toString();
	}

	@Override
	public boolean lost() {
		return isLost;
	}

	@Override
	public void uncoverCells(int x, int y, int sizeBoard) {
		if (grid[x][y] instanceof MineCell) {
			this.isLost = true;
			uncover(x, y);
			return;
		}
		uncoverRecursive(x,y,sizeBoard);
		checkWinner();	
	}
	
	private void uncoverRecursive(int x, int y, int sizeBoard) {
		if (!Util.cellInsideBroad(x,y,sizeBoard) || wasUncovered(x, y) || isThereMine(x, y)) {
			return;
		}
		uncover(x, y);
		if (!isThereMine(x, y) && !isThereTrack(x, y)) {
			uncoverRecursive(x+1, y, sizeBoard);
			uncoverRecursive(x-1, y, sizeBoard);
			uncoverRecursive(x, y+1, sizeBoard);
			uncoverRecursive(x, y-1, sizeBoard);
		} 
	}
	
	private boolean isThereTrack(int x, int y) {
		return this.grid[x][y] instanceof TrackCell  ? true : false; 
	}
	
	private boolean isThereMine(int x, int y) {
		return this.grid[x][y] instanceof MineCell ? true : false; 
	}
	
	private void uncover(int x, int y) {
		this.grid[x][y].setWasSelected(true);
	}
	
	private boolean wasUncovered(int x, int y) {
		return this.grid[x][y].isWasSelected(); 
	}

	@Override
	public void uncoverAllCells() {
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid.length; j++) {
				this.grid[i][j].setWasSelected(true);
			}
		}
	}

	@Override
	public void checkWinner() {
		int numberNotSelected = 0;
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid.length; j++) {
				if (!this.grid[i][j].isWasSelected()) {
					numberNotSelected++;
					if (numberNotSelected > 10) {
						return;
					}
				}
			}
		}
		isWinner = true;
	}
}
