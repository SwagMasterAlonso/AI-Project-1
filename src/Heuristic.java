
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

		finalValue = 20*nMinus1 + 10*nMinus2 + oppNMinus1 + oppNMinus2 + ((nMinus2 - longestN) * 2)*longestN +
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

	void setState(Board state) {
		this.currentState = state;
	}
}
