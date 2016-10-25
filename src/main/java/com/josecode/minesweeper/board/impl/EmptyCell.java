package com.josecode.minesweeper.board.impl;

public class EmptyCell extends InitialCell {
    
	private static final String EMPTY = " ";

	@Override
	public String getCellRepresentation() {
		return EMPTY;
	}
}
