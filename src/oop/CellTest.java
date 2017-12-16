package oop;

public class CellTest {
	public static void main(String[] args) {
		Cell c = new Cell();
		c.row=1;
		c.col=2;
		System.out.println(c.getCellInfo());//1,2
		c.drop();
		System.out.println(c.getCellInfo());//1,3
		int move;
		move = 1;
		c.landscape(move);
		System.out.println(c.getCellInfo());//2,3
		move = -2;
		c.landscape(move);
		System.out.println(c.getCellInfo());//0,3
		printWall(c);
	}
	public static void printWall(Cell c){
		for(int i=1;i<+20;i++){
			for(int j=1;j<+10;j++){
				if(c.row==j && c.col==i){
					System.out.print("*"+" ");
				}else{
					System.out.print("-"+" ");
				}
			}
			System.out.println();
		}
	}
}
