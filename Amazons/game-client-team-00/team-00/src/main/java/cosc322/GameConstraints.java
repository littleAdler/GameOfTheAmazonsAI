package cosc322;

import cern.colt.Arrays;

public class GameConstraints {
	GameBoard[][] board = new GameBoard[10][10];
	
	
	public GameConstraints() {
		board = new GameBoard[][]{
			{null,null,null,new Queen(0,3,"Black"),null,null,new Queen(0,6,"Black"),null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{new Queen(3,0,"Black"),null,null,null,null,null,null,null,null,new Queen(3,9,"Black")},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{new Queen(6,0,"White"),null,null,null,null,null,null,null,null,new Queen(6,9,"White")},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,new Queen(9,3,"White"),null,null,new Queen(9,6,"White"),null,null,null},
			
		};
		
		
	}
	public void updateBoard(Integer[] move){
		//move contains the queens new position and the arrow location (msg from the server or our move)
		//*** Read move message from the server ***
		
		//Check coordinate validity in console (for debugging)
		System.out.println("Game Board Update Success");
		System.out.println("Returned: " + Arrays.toString(move));
		
		//Update local game board using coordinate conversion
		
		//Convert to our game board coordinate system
		int oldRow =10-move[4];
		int oldCol = move[5]-1;
		int newRow =10-move[0];
		int newCol= move[1]-1;
		
		
		System.out.println("Local coorinate update: " + oldRow +","+oldCol+","+newRow+","+newCol+"");
		
		
		if(board[oldRow][oldCol]!=null){
			//Store whether it is a black or white queen
			String side = board[oldRow][oldCol].toString().substring(0, 5);
			System.out.println(side);
		
			//remove the current queen from its original position
			board[oldRow][oldCol]=null;
			//place the queen in the new location
			board[newRow][newCol] = new Queen(newRow,newCol,side);
			
			//print board after updating
			printBoard();
		}
		
	}
	
	//print out the local board
	public void printBoard(){
		
		StringBuilder row = new StringBuilder();
		
		for(int i=0; i<10; i++){
			//reset the string builder row for each line of the game board
			row.setLength(0);
			
			for(int j=0; j<10; j++){
				if(board[i][j] == null){//handle the null case first, so subsequent cases don't have to worry about a "null.toString()" error
					row.append("|___|");
				}else if(board[i][j].toString().equals("White Queen")){
					row.append("|_W_|");
				}else if(board[i][j].toString().equals("Black Queen")){
					row.append("|_B_|");
				}
				//TODO: Add a statement for inserting arrows onto local board display
			}
		//Print out each row of the game board individually
		System.out.println(row);
		}
	}
	
	

}
