import java.util.ArrayList;
import java.util.Random;

public class MinMaxAlgorithm {

	int playerNum;
	int opponentNum;
	Board currentState;
	Move opponentMove;
	Move friendlyMove;

	public MinMaxAlgorithm(Board state, int playerNum, int opponent) {
		this.playerNum = playerNum;
		this.opponentNum = opponent;
		this.currentState = state;
	}

	void getNextMove () {
		Random rand = new Random();
		//code for finding the next move
		//This is a random number generator that creates random moves
		int randomNum = rand.nextInt((6-1)+1) + 1;

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

		for (i = 0; i < this.currentState.height; i++) {
			for (j = 0; j < this.currentState.width; j++) {
				if (currentState[i][j] != 9 && !isRowFound) {
					rowStop = i;
					isRowFound = true;
					break;
				}
			}
		}


		//second loop to place valid moves on lists.
		for (i = this.currentState.height-1; i >= rowStop; i--) {
			for (j = 0; j < this.currentState.width; j++) {
				if (currentState[i][j] == 9) {
					openList.add(j);
				}
			}
		}
	}
}
