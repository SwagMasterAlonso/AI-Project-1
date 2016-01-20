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
	int minimax(int depth, boolean isMax) {
		int i, bestScore = 0;
		Board current = this.currentState;
		Move newMove;


		if (currDepth == 0) {

			return eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum);

		} else if(isMax) {
			bestScore = -10000;

			//iterate through all nodes here
//			int tempVal = minimax(child,depth -1,false);
//
//			bestScore= Math.max(bestScore,tempVal);


			//stop iterating through all nodes here
			return bestScore;
		} else {
			bestScore = 10000;

			//iterate through all nodes here
//			int tempVal = minimax(child,depth -1,true);
//
//			bestScore= Math.min(bestScore,tempVal);


			//stop iterating through all nodes here
			return bestScore;
		}
	}






	GameNode createGameTree(int depth, Board givenState, Move move) {
		Move newMove = move;
		ArrayList<GameNode> nextMoves = createLayers(depth, givenState);

		GameNode tree = new GameNode(newMove.getCol(), givenState, nextMoves);

		return tree;
	}

	private ArrayList<GameNode> createLayers(int depth, Board current) {
		Move newMove;
		int i;
		GameNode newLeaf;
		ArrayList<GameNode> list = new ArrayList<GameNode>();
		if (depth == 0) {
			return null;
		}
		ArrayList<Integer> validMoves = this.findMoves(current);
		if (validMoves.isEmpty()) {
			return null;
		}
		for (i = 0; i < validMoves.size(); i++) {
			newMove = new Move(validMoves.get(i), this.playerNum);
			Board boardCopy = current;
			newLeaf = new GameNode(validMoves.get(i), this.modifyState(current, newMove, this.playerNum), this.createLayers(depth - 1, current));
			list.add(newLeaf);
		}
		return list;
	}

	ArrayList<Integer> findMoves(Board state) {
		int i;
		ArrayList<Integer> openList = new ArrayList<Integer>();

		for (i = 0; i < 7; i++) {
			if (state.canDropADiscFromTop(i, this.playerNum)) {
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
