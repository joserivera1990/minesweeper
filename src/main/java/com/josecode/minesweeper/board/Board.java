package com.josecode.minesweeper.board;

public interface Board {
  
	boolean won();
	
	boolean lost();
	
	void uncoverCells(int x, int y, int sizeBoard);
	
	void uncoverAllCells();
	
	void checkWinner();
}
