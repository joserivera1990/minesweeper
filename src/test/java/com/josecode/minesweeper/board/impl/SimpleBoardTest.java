package com.josecode.minesweeper.board.impl;

import org.junit.Before;
import org.junit.Test;

import com.josecode.minesweeper.board.Cell;

import static org.junit.Assert.assertTrue;

public class SimpleBoardTest {
    
	Cell[][] grid;
	
	@Before
	public void setup() {
		grid = new Cell[9][9];
		grid[5][5] = new MineCell();
	}
	
	@Test
	public void chooseCellThatHasMine() {
		SimpleBoard simpleBoard = new SimpleBoard(9,10);
		simpleBoard.grid = grid;
		simpleBoard.uncoverCells(5, 5, 9);
		assertTrue(simpleBoard.lost());	    
	}
	
}
