public class Move {
	int colNum;
	boolean isDrop;
	boolean isPop;

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

	int getCol () {
		return this.colNum;
	}

	boolean checkDrop() {
		return this.isDrop;
	}

	boolean checkPop() {
		return this.isPop;
	}

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
