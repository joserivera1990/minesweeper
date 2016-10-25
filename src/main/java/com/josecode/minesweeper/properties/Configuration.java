package com.josecode.minesweeper.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuration {

	private final int size;
	private final int numberMines;
	
	public Configuration() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties p = new Properties();
		p.load(inputStream);
		size = Integer.parseInt(p.getProperty("board.size"));
		numberMines = Integer.parseInt(p.getProperty("mine.number"));
	}

	public int getSize() {
		return size;
	}

	public int getNumberMines() {
		return numberMines;
	}

}
