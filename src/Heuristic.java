
public class Heuristic {
	private Board currentState;

	public Heuristic() {
	}

	int evaluate (int n, int player, int other) {
		int finalValue = 0;
		int nMinus1, nMinus2, oppNMinus1, oppNMinus2;
		int longestN=0, emptySpaces=0, vertConn, horizConn, diagConn=0;

		nMinus1 = this.countNConnectionsH(n-1, player, other) + this.countNConnectionsV(n-1, player, other);
		nMinus2 = this.countNConnectionsH(n-2, player, other) + this.countNConnectionsV(n-2, player, other);

		oppNMinus1 = this.countNConnectionsH(n-1, other, player) + this.countNConnectionsV(n-1, other, player);
		oppNMinus2 = this.countNConnectionsH(n-2, other, player) + this.countNConnectionsV(n-2, other, player);

		vertConn = this.countNConnectionsV(n-1, player, other) + this.countNConnectionsV(n-2, player, other);
		horizConn = this.countNConnectionsH(n-1, player, other) + this.countNConnectionsH(n-2, player, other);

		finalValue = 20*nMinus1 + 10*nMinus2 - 20*oppNMinus1 - 10*oppNMinus2 + ((nMinus2 - longestN) * 2)*longestN +
				5*emptySpaces + 5*vertConn + 16*horizConn + 18*diagConn;

		return finalValue;
	}

	int countNConnectionsH(int n, int player, int other) {
		int max1;
		int max2;
		int counter = 0;

		//check each row, horizontally
		for(int i=0;i<this.currentState.height;i++){
			max1=0;
			max2=0;
			for(int j=0;j<this.currentState.width;j++){
				if(this.currentState.board[i][j]==player){
					max1++;
					max2=0;

				}
				else if(this.currentState.board[i][j]==other){
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2++;
				} else {
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2=0;
				}
			}
			if(max1==n) {
				counter++;
			}
		}
		return counter;
	}

	int countNConnectionsV(int n, int player, int other) {
		int max1;
		int max2;
		int counter = 0;

		//check each row, horizontally
		for(int j=0;j<this.currentState.width;j++){
			max1=0;
			max2=0;
			for(int i=0;i<this.currentState.height;i++){
				if(this.currentState.board[i][j]==player){
					max1++;
					max2=0;
				} else if (this.currentState.board[i][j]==other){
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2++;
				} else {
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2=0;
				}
			}
			if(max1==n) {
				counter++;
			}
		}
		return counter;
	}

	int countNConnectionsDiag(int n, int player, int other) {
		//check diagonally y=-x+k
		int max1=0;
		int max2=0;
		int height = this.currentState.height;
		int width = this.currentState.width;
		int[][] board = this.currentState.board;
		int counter = 0;
		int upper_bound=height-1+width-1-(n-1);

		for(int k=n-1;k<=upper_bound;k++){
			max1=0;
			max2=0;
			int x,y;
			if(k<width)
				x=k;
			else
				x=width-1;
			y=-x+k;

			while(x>=0  && y<height){
				// System.out.println("k: "+k+", x: "+x+", y: "+y);
				if(board[height-1-y][x]==player){
					max1++;
					max2=0;
				}
				else if(board[height-1-y][x]==other){
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2++;

				}
				else{
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2=0;
				}
				x--;
				y++;
			}
			if(max1==n) {
				counter++;
			}
		}
		return counter;
	}

	int countNConnectionsDiag2(int n, int player, int other) {
		//check diagonally y=x-k
		int max1=0;
		int max2=0;
		int counter = 0;
		int width = this.currentState.width;
		int height = this.currentState.height;
		int[][] board = this.currentState.board;
		int upper_bound=width-1-(n-1);
		int  lower_bound=-(height-1-(n-1));
		// System.out.println("lower: "+lower_bound+", upper_bound: "+upper_bound);
		for(int k=lower_bound;k<=upper_bound;k++){
			max1=0;
			max2=0;
			int x,y;
			if(k>=0)
				x=k;
			else
				x=0;
			y=x-k;
			while(x>=0 && x<width && y<height){
				// System.out.println("k: "+k+", x: "+x+", y: "+y);
				if(board[height-1-y][x]==player){
					max1++;
					max2=0;
				}
				else if(board[height-1-y][x]==other){
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2++;

				}
				else{
					if(max1==n) {
						counter++;
					}
					max1=0;
					max2=0;
				}
				x++;
				y++;
			}
			if(max1==n) {
				counter++;
			}
		}	 //end for y=x-k
		return counter++;
	}

	void setState(Board state) {
		this.currentState = state;
	}
}
