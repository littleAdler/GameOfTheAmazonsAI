package cosc322;

public class Queen extends GameBoard {
	//Limit access to subclass (same package)
	int row;
	int col;
	String side;
	
	public Queen(int row, int col, String side){
		super(row,col);
		this.side = side;
		
	}
	
	//TODO: method to update queen position
	public void updateQueenPosition(int row, int col){
		//update the queen objects position
		super.row = row;
		super.col = col;
		
	}
	
	//get queen object location
	public int[] getQueenLocation(){
		int[] location = {this.col,this.row};
		return location;
	}
	
	//get the side (black or white) the queen is on
	public String getQueenSide(){
		String side =  this.side;
		return side;
	}
	
	public String toString(){
		//returns the side the queen object is on
		return getQueenSide() + " Queen";
	}
	
	
}
