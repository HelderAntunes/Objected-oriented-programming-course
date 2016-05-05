package chessGame.logic;

import java.util.ArrayList;

public class ChessGame {
	
	private Board board;
	private Player playerWhite = new Player(Color.WHITE);
	private Player playerBlack = new Player(Color.BLACK);
	private boolean isWhiteToPlay = true;
	
	
	public ChessGame(char[][] board){
		this.board = new Board(board);
	}
	
	public ArrayList<Position> getPossibleMoves(Position position){
		return board.getPossibleMoves(position);
	}
	
	/**
	 * Move a piece in initial position to a new position.
	 * The function return false when there isn't a piece in initial position, 
	 * the player try move a opponent piece, or the move is invalid
	 * 
	 * @param iniPosition initial position
	 * @param endPosition end position
	 * @return true if the move was successful , false otherwise.
	 */
	public boolean move(Position iniPosition, Position endPosition){
		
		if(board.getBox(iniPosition).isEmpty() == true)
			return false;
		
		if(isWhiteToPlay == true && board.getBox(iniPosition).getPiece().getColor() == Color.BLACK)
			return false;
		
		if(isWhiteToPlay == false && board.getBox(iniPosition).getPiece().getColor() == Color.WHITE)
			return false;
		
		ArrayList<Position> possibleMoves = getPossibleMoves(iniPosition);
		for(int i = 0;i < possibleMoves.size();i++)
			if(possibleMoves.get(i).equals(endPosition)){
				board.move(iniPosition, endPosition);
				isWhiteToPlay = !isWhiteToPlay;
				return true;
			}
		
		return false;
	}
	
	public char[][] getBoard(){
		return board.getBoard();
	}

}
