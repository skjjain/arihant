package com.arihant.firstandengineproject;



public class TicTacToeModel {
	
	public enum Piece {
		X, O, _
	};

	private final int GRID_WIDTH = 3;
	private final int GRID_HEIGHT = 3;

	private Piece[][] board = new Piece[GRID_HEIGHT][GRID_WIDTH];
	private Piece currentPlayer;

	public TicTacToeModel() {
		reset();
	}

	public void reset() {
		for (int i = 0; i < GRID_HEIGHT; i++) {
			for (int j = 0; j < GRID_WIDTH; j++) {
				board[i][j] = Piece._;
			}
		}
	}

	public Piece getCurrentPlayer() {
		return currentPlayer;
	}

	public void setValue(int row, int col, Piece p) {
		togglePlayer();
		board[row][col] = p;
	}

	private void togglePlayer() {
		if (currentPlayer == Piece.X)
			currentPlayer = Piece.O;
		else
			currentPlayer = Piece.X;
	}

	public Piece getValue(int row, int col) {
		return board[row][col];
	}
	
	public Piece checkWinner(){
		Piece winner = Piece._;
		
		//check rows
		for (int i = 0; i < GRID_HEIGHT; i++) {
			if(board[i][0] == board[i][0] && board[i][1] == board[i][2]){
				winner = board[i][0];
			}
		}
		
		//check cols
		for (int i = 0; i < GRID_WIDTH; i++) {
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
				winner =  board[0][i];
			}
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			winner =  board[0][0];
		}
		
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2]){
			winner = board[2][0];
		}
		
		return winner;
	}

}
