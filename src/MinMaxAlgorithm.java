import java.util.ArrayList;
import java.util.Random;

public class MinMaxAlgorithm {

	int playerNum;
	int opponentNum;
	Board currentState;
	Move opponentMove;
	Move friendlyMove;
	Debugger debugger;
	Heuristic eval;


	public MinMaxAlgorithm(Board state, int playerNum, int opponent) {
		this.playerNum = playerNum;
		this.opponentNum = opponent;
		this.currentState = state;
		this.eval = new Heuristic();
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

}
