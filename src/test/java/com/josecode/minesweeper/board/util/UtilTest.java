package com.josecode.minesweeper.board.util;

import org.junit.Before;
import org.junit.Test;

import com.josecode.minesweeper.board.Cell;
import com.josecode.minesweeper.board.impl.MineCell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UtilTest {
    
	Cell[][] grid;
	
	@Before
	public void setup() {
		grid = new Cell[9][9];
		grid[5][5] = new MineCell();
	}
	
	@Test
	public void fillAllCells() {
		Util.fillMissingCells(grid, 9);
		int cellsNull = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid.length; ++j) {
				if (grid[i][j] == null) {
					cellsNull++;
				}
			}
		}
		assertEquals(0, cellsNull);
	}
	
	@Test
	public void cellInsideBroadTest() {
		boolean insideBroad = Util.cellInsideBroad(8, 5, 9);
		assertTrue(insideBroad);	
	}
	
	@Test
	public void cellOutBroadTest() {
		boolean insideBroad = Util.cellInsideBroad(9, 5, 9);
		assertFalse(insideBroad);	
	}
	
	@Test
	public void createNumbersRowTest() {
		String response = Util.createNumbersRow(9);
		assertEquals(response, " 123456789");
	}
	
}
