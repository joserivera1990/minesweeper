package com.josecode.minesweeper.board.impl;

public class MineCell extends InitialCell {
    
	private static final String MINE = "*";

	@Override
	public String getCellRepresentation() {
		return MINE;
	}
	
}
