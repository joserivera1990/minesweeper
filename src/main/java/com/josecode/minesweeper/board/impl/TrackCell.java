package com.josecode.minesweeper.board.impl;

public class TrackCell extends InitialCell {
	
    private String numberTrack;
    
    public TrackCell(int numberTrack) {
		this.numberTrack = String.valueOf(numberTrack);
	}
    
	@Override
	public String getCellRepresentation() {
		return this.numberTrack;
	}
}
