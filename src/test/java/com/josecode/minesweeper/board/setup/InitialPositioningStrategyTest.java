package com.josecode.minesweeper.board.setup;

import org.junit.Test;

import com.josecode.minesweeper.board.Cell;
import com.josecode.minesweeper.board.impl.MineCell;

import static org.junit.Assert.assertEquals;

public class InitialPositioningStrategyTest {
    
	@Test
	public void createTenMines() {
		Cell[][] grid = InitialPositioningStrategy.getInstance().createBoard(9, 10);
		int minesFound = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid.length; ++j) {
				if (grid[i][j] instanceof MineCell) {
                    minesFound++;
				}
			}
		}
		assertEquals(10, minesFound);
	}
	
	@Test
	public void fillAllBoard() {
		Cell[][] grid = InitialPositioningStrategy.getInstance().createBoard(9, 10);
		int numberCellsNull = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid.length; ++j) {
				if (grid[i][j] == null) {
					numberCellsNull++;
				}
			}
		}
		assertEquals(0, numberCellsNull);
	}
}
