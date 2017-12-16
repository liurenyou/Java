package oop;

public class Cell {
	int row;
	int col;
	
	void drop(){
		col++;
	}
	
	void landscape(int n){
		row+=n;
	}
	
	String getCellInfo(){
		return row+","+col;
	}
}
