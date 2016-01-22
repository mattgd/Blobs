package me.mattgd.blobs;

public class Blobs {

	//1 for black and 0 for white
		private int[][] board;  
		//Keeps track of whose turn it is
		private int whoseTurn = 1;
		private BlobsPanel bPanel;

		//size is both the width and the height of the board
		//randomizes data on board to 0’s and 1’s
		Blobs(int size, BlobsPanel bPanel)	{
			this.bPanel = bPanel;
			board = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = Math.random() < 0.5 ? 0 : 1;
				}
			}
		}
		
		// This method accepts a row & col and then follows the rule:
		//	-check if spot is other color
		//	TRUE	-change color
		//		-spread up,down,right,left
		//		-update whoseTurn
		//		-return true
		//	FALSE	-exit method
		public boolean pick(int row, int col) {
			if (board[row][col] != whoseTurn) {
				board[row][col - 1] = whoseTurn;
				board[row][col + 1] = whoseTurn;
				board[row - 1][col] = whoseTurn;
				board[row + 1][col] = whoseTurn;
				
				if (whoseTurn == 0) {
					whoseTurn++;
				} else {
					whoseTurn--;
				}
				
				bPanel.repaint();
				return true;
			}
			
			return false;
		}
		
		public int[][] getBoard() {
			return board;
		}
		
		public String toString() {
			String s = "";
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					s += board[i][j] + " ";
				}
				s += "\n";
			}
			
			return s;
		}
	
}
