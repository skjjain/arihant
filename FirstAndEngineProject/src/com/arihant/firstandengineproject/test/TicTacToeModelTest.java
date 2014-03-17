package com.arihant.firstandengineproject.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.arihant.firstandengineproject.TicTacToeModel;
import com.arihant.firstandengineproject.TicTacToeModel.Piece;

public class TicTacToeModelTest {

	@Test
	public void testXWins() {
		TicTacToeModel board = new TicTacToeModel();
		board.setValue(0, 0, Piece.X);
		board.setValue(1, 1, Piece.X);
		board.setValue(2, 2, Piece.X);
		assertEquals("The winner should be X", board.checkWinner(), Piece.X);
	}
	
	@Test
	public void testOWins() {
		TicTacToeModel board = new TicTacToeModel();
		board.setValue(0, 0, Piece.O);
		board.setValue(1, 1, Piece.O);
		board.setValue(2, 2, Piece.O);
		assertEquals("The winner should be O", board.checkWinner(), Piece.O);
	}
	
	@Test
	public void sanityTest() {
		TicTacToeModel board = new TicTacToeModel();
		board.setValue(0, 0, Piece.O);
		assertEquals("The player should be X", board.getCurrentPlayer(), Piece.X);
	}

}
