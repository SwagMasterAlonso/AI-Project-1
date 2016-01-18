
public class Heuristic {
	private Board currentState;

	public Heuristic() {
	}

	int evaluate (int player) {


		return 0;
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

				if(max1==n) {
					counter++;
				}
			}
		}
		return counter;

	}

	void setState(Board state) {
		this.currentState = state;
	}
}
