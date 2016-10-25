package com.josecode.minesweeper.board.setup;

import java.util.Random;

import com.josecode.minesweeper.board.Cell;
import com.josecode.minesweeper.board.impl.MineCell;
import com.josecode.minesweeper.board.util.Util;

public class InitialPositioningStrategy {
     
	private Random random = new Random();
	private static InitialPositioningStrategy instance;
	
	public static synchronized InitialPositioningStrategy getInstance() {
		if (instance == null) {
			instance = new InitialPositioningStrategy();
		}
		return instance;
	}
	
	public Cell[][] createBoard(int size, int numberMines) {
		Cell[][] grid = new Cell[size][size];
        int numberMinesCreated = 0;
		
        while (numberMines > numberMinesCreated) {
        	int x = random.nextInt(size);
			int y = random.nextInt(size); 
			if (grid[x][y] == null) {
				grid[x][y] = new MineCell();
				numberMinesCreated++;
			}		
        }
		Util.fillMissingCells(grid,size);
		return grid;
	}
}
