package com.josecode.minesweeper.board;

public interface Cell {
       
	String getCellRepresentation();
	
	boolean isWasSelected();
	
	void setWasSelected(boolean wasSelected);
	
}
