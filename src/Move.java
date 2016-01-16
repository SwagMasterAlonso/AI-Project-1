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

}
