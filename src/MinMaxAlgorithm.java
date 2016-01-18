import java.util.ArrayList;
import java.util.Random;

public class MinMaxAlgorithm {

	int playerNum;
	int opponentNum;
	Board currentState;
	Move opponentMove;
	Move friendlyMove;
	Debugger debugger;


	public MinMaxAlgorithm(Board state, int playerNum, int opponent) {
		this.playerNum = playerNum;
		this.opponentNum = opponent;
		this.currentState = state;
		this.debugger = new Debugger();
	}

	void getNextMove () {
		Random rand = new Random();
		//code for finding the next move
		//This is a random number generator that creates random moves
		int randomNum = rand.nextInt((6-1)+1) + 1;
		this.debugger.writeToDebug("col is: "+randomNum);
		this.friendlyMove = new Move(randomNum, 1);

	}

	void readMove(Move opponent){
		this.opponentMove = opponent;

		this.currentState.dropADiscFromTop(opponent.getCol(), this.opponentNum);

	}

	void writeMove() {
		this.currentState.dropADiscFromTop(this.friendlyMove.getCol(), this.playerNum);

		System.out.println(this.friendlyMove.toString());
	}

	void searchValidMoves() {
		int i,j;
		int rowStop = 0;
		boolean isRowFound = false;
		ArrayList<Integer> openList = new ArrayList<Integer>();
		ArrayList<Integer> closedList = new ArrayList<Integer>();
		int[][] currentState = this.currentState.getBoard();


	}

	int countNConnectionsH(int n, int player) {
		int max1;
		int max2;
		int counter = 0;
		//check each row, horizontally
		for(int i=0;i<this.currentState.height;i++){
			max1=0;
			max2=0;
			for(int j=0;j<this.currentState.width;j++){
				if(this.currentState.board[i][j]==this.playerNum){
					max1++;
					max2=0;

				}
				else if(this.currentState.board[i][j]==this.opponentNum){
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
		}
		return counter;
	}

	int countNConnectionsV(int n, int player) {
		int max1;
		int max2;
		int counter = 0;
		//check each row, horizontally
		for(int j=0;j<this.currentState.width;j++){
			max1=0;
			max2=0;
			for(int i=0;i<this.currentState.height;i++){
				if(this.currentState.board[i][j]==this.playerNum){
					max1++;
					max2=0;
				}
				else if(this.currentState.board[i][j]==this.opponentNum){
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
		}
		return counter;

	}
}
