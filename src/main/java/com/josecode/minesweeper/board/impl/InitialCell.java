package com.josecode.minesweeper.board.impl;

import com.josecode.minesweeper.board.Cell;

public abstract class InitialCell implements Cell{

	private static final String INITIAL = ".";
	protected boolean wasSelected = false;
	
	@Override
	public boolean isWasSelected() {
		return wasSelected;
	}
    
	@Override
	public void setWasSelected(boolean wasSelected) {
		this.wasSelected = wasSelected;
	}

	@Override
	public String toString() {
		return !this.wasSelected ? INITIAL : getCellRepresentation();
	}
	
	
}
