package com.josecode.minesweeper;

import java.io.IOException;
import java.util.Scanner;

import com.josecode.minesweeper.board.Board;
import com.josecode.minesweeper.board.impl.SimpleBoard;
import com.josecode.minesweeper.board.util.Util;
import com.josecode.minesweeper.properties.Configuration;

public class Main {
   
    public static void main(String[] args) {
  		try (Scanner in = new Scanner(System.in)) {
  			Configuration configuration = new Configuration();
  			
  			Board board = new SimpleBoard(configuration.getSize(),configuration.getNumberMines());
			while (!board.won() && !board.lost() ) {
				System.out.println(board);
				System.out.println("Please type a number for column more enter");
                int x = in.nextInt();
                System.out.println("Please type a number for row more enter ");
                int y = in.nextInt();
                if (Util.cellInsideBroad(x-1, y-1, configuration.getSize())) {
                	board.uncoverCells(y-1, x-1, configuration.getSize());
                } else {
                	System.out.println("Numbers is not inside Broad");
                }	
			}
			board.uncoverAllCells();
			System.out.println(board);
			if (board.won()) {
				System.out.println("!!!!!WINNER!!!!!");
			} else {
				System.out.println("!!!!!!LOSER!!!!!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
