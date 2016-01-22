
public class Heuristic {
	private Board currentState;

	public Heuristic() {
	}

	int evaluate (int n, int player, int other) {
		int finalValue = 0;
		int nMinus1, nMinus2, oppNMinus1, oppNMinus2, connectN, oppConnectN;
		int longestN=0, oppLongestN = 0, emptySpaces=0, vertConn, horizConn, diagConn=0;
		int temp = 0, temp2 = 0;

		connectN = this.countNConnectionsH(n, player, other) + this.countNConnectionsV(n, player, other) + this.countNConnectionsDiag(n, player, other)
		+ this.countNConnectionsDiag2(n, player, other);

		oppConnectN = this.countNConnectionsH(n, other, player) + this.countNConnectionsV(n, other, player) + this.countNConnectionsDiag(n, other, player)
		+ this.countNConnectionsDiag2(n, other, player);

		nMinus1 = this.countNConnectionsH(n-1, player, other) + this.countNConnectionsV(n-1, player, other) + this.countNConnectionsDiag(n-1, player, other)
				+ this.countNConnectionsDiag2(n-1, player, other);
		nMinus2 = this.countNConnectionsH(n-2, player, other) + this.countNConnectionsV(n-2, player, other) + this.countNConnectionsDiag(n-2, player, other)
				+ this.countNConnectionsDiag2(n-2, player, other);

		oppNMinus1 = this.countNConnectionsH(n-1, other, player) + this.countNConnectionsV(n-1, other, player) + this.countNConnectionsDiag(n-1, other, player)
					+ this.countNConnectionsDiag2(n-1, other, player);
		oppNMinus2 = this.countNConnectionsH(n-2, other, player) + this.countNConnectionsV(n-2, other, player) + this.countNConnectionsDiag(n-2, other, player)
		+ this.countNConnectionsDiag2(n-2, other, player);

		vertConn = this.countNConnectionsV(n-1, player, other) + this.countNConnectionsV(n-2, player, other);
		horizConn = this.countNConnectionsH(n-1, player, other) + this.countNConnectionsH(n-2, player, other);
		diagConn = this.countNConnectionsDiag(n-1, player, other) + this.countNConnectionsDiag2(n-2, player, other) +
				this.countNConnectionsDiag(n-2, player, other) + this.countNConnectionsDiag2(n-2, player, other);

		temp = this.longestN(n-3, player, other);
		if (temp > 1) {
			longestN = this.countNConnectionsH(temp, player, other) + this.countNConnectionsV(temp, player, other) + this.countNConnectionsDiag(temp, player, other)
			+ this.countNConnectionsDiag2(temp, player, other);
		}

		temp2 = this.longestN(n-3, other, player);

		if (temp2 > 1) {
			oppLongestN = this.countNConnectionsH(temp, other, player) + this.countNConnectionsV(temp, other, player) + this.countNConnectionsDiag(temp, other, player)
			+ this.countNConnectionsDiag2(temp, other, player);

		}
//		System.out.println("");
//		System.out.println("nMinus1 " +nMinus1);
//		System.out.println("");
//		System.out.println("nMinus2 " +nMinus2);
//		System.out.println("");
//		System.out.println("vertConn " +vertConn);
//		System.out.println("");
//		System.out.println("horizConn " +horizConn);
//		System.out.println("");
//		System.out.println("oppnMinus1 " +oppNMinus1);
//		System.out.println("");
//		System.out.println("oppnMinus2 " +oppNMinus2);
//		System.out.println("");
//		System.out.println("oppnN " +oppConnectN);
//		System.out.println("");
//		System.out.println("diag " +diagConn);
//		System.out.println("");


		finalValue = 40*connectN - 60*oppConnectN + 20*nMinus1 + 10*nMinus2 - 20*oppNMinus1 - 10*oppNMinus2 + ((nMinus2 - longestN) * 2)*longestN -
				((oppNMinus2 - oppLongestN) * 2)*oppLongestN + 5*emptySpaces + 5*vertConn + 16*horizConn + 18*diagConn;


		//System.out.println("Fin Val is: " +finalValue);

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

	private int longestN (int n, int player1, int player2) {
		for (int i = n; i > 0; i--) {
			if (this.countNConnectionsH(i, player1, player2) > 0 || this.countNConnectionsV(i, player1, player2) > 0 ||
					this.countNConnectionsDiag(i, player1, player2) > 0 || this.countNConnectionsDiag2(i, player1, player2) > 0) {
				return i;
			}
		}
		return 0;
	}

	void setState(Board state) {
		this.currentState = state;
	}
}
