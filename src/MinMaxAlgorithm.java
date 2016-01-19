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
	static int currDepth;


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

	/**
	 * This function should first search all the valid moves of the board
	 * Then call a helper function to find the nth valid move given the first valid move
	 * Then
	 */
	void planNextMoves(int depth, Board givenState) {
		int i;
		Board current = this.currentState;
		Move newMove;

		if (currDepth == depth) {
			return;
		}
		ArrayList<Integer> validMoves = this.findMoves(current);
		for (i = 0; i < validMoves.size(); i++) {
			current = this.currentState;
			newMove = new Move(validMoves.get(i), this.playerNum);
			this.modifyState(current, newMove, this.playerNum);
			this.planNextMoves(depth, current);
		}
		currDepth++;

	}

	ArrayList<Integer> findMoves(Board state) {
		int i;
		ArrayList<Integer> openList = new ArrayList<Integer>();

		for (i = 0; i < 7; i++) {
			if (this.currentState.canDropADiscFromTop(i, this.playerNum)) {
				openList.add(i);
			}
		}
		return openList;
	}
	/**
	 * Returns a board with the move.
	 * @param current
	 * @param move
	 * @param player
	 *
	 */
	Board modifyState(Board current, Move move, int player) {
		current.dropADiscFromTop(move.getCol(), player);
		return current;
	}

}
