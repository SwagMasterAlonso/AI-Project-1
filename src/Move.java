/**
 * The purpose of this class is the save valid moves to an object.
 * @author jameschow, amartinez
 *
 */
public class Move {
	int colNum;/**Designated column to drop a disk.*/
	boolean isDrop;/**Determines if the valid move is a drop.*/
	boolean isPop;/**Determines if the valid move is a pop.*/

	/**
	 * Constructor that creates a move object for a valid move on connect-N.
	 * @param col
	 * @param moveType
	 */
	public Move(int col, int moveType) {
		this.colNum = col;
		if (moveType == 1) {
			this.isDrop = true;
			this.isPop = false;
		} else {
			this.isDrop = false;
			this.isPop = true;
		}
	}

	/**
	 *
	 * @return The designated column to drop a disk.
	 */
	int getCol () {
		return this.colNum;
	}

	/***
	 *
	 * @return True if the move is a drop, false otherwise.
	 */
	boolean checkDrop() {
		return this.isDrop;
	}

	/***
	 *
	 * @return True if the move is a pop, false otherwise.
	 */
	boolean checkPop() {
		return this.isPop;
	}

	/**
	 * ToString method for print a move object, debugging purposes.
	 */
	public String toString() {
		int temp = 0;
		if (this.isDrop) {
			temp = 1;
		} else if (this.isPop) {
			temp = 0;
		}
		return this.colNum +" "+ temp;
	}
}
