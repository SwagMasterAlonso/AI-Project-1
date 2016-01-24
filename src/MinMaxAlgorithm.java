import java.util.ArrayList;
import java.util.Collections;
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
	int tempValMax;
	int tempValMin;
	int score = -100000;
	public MinMaxAlgorithm(Board state, int playerNum, int opponent) {
		this.playerNum = playerNum;
		this.opponentNum = opponent;
		this.currentState = state;
		this.eval = new Heuristic();
		this.debugger = new Debugger();
	}

	void getNextMove () {
		ArrayList <Integer> validMoves = new ArrayList<Integer>();
		Move bestMove = null;
		int tempScore = -10000;
		GameNode tree = null;
		Move move = null;
		int i;
		//	Random rand = new Random();
		//code for finding the next move
		//This is a random number generator that creates random moves
		//		int randomNum = rand.nextInt((6-1)+1) + 1;
		//		this.debugger.writeToDebug("col is: "+randomNum);
		//		this.friendlyMove = new Move(randomNum, 1);
		validMoves = findMoves(this.currentState);
		//Collections.reverse(validMoves);
		
		for(i = 0; i < validMoves.size();i++){
			
			
			System.out.println("");
			System.out.println("");
			System.out.println("Exploring validMoves at: " + i);
		//	System.out.println(tempScore);
		//	System.out.println(score);
			System.out.println("");
			System.out.println("");

			move = new Move(validMoves.get(i),1);
			tree = createGameTree(2,this.currentState,move);		
			tempScore = this.minimax(tree, 2, true, -10000, 10000);
			score= Math.max(score, tempScore);

			if(tempScore >= score){
				//System.out.println("Best Move is: "+bestMove);
				bestMove = move;
				System.out.println("");
				System.out.println(tempScore);
				System.out.println(score);
				System.out.println("Best Move is: "+bestMove);
				score = tempScore;
				System.out.println("Best score is: "+score);
				System.out.println("");
			//	System.out.println("Col is " +bestMove.colNum);
			} else {
				System.out.println("Lower");
			}
		}

		this.friendlyMove = bestMove;
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


	int minimax(GameNode gameNode,int depth, boolean isMax,int alpha, int beta) {
		int i,j ,bestScore = 0;
		
		//Move newMove;

		//friendly move should be up to date
		//GameNode tree = this.createGameTree(depth, this.currentState,this.friendlyMove);

		if (depth == 0 || gameNode.getNextLayer() ==null ) {

			this.eval.setState(gameNode.getState());
		//	System.out.println("Eval is: " +  eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum));
			return eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum);

		} else if(isMax) {
			bestScore = -10000;

			//iterate through all nodes here


			for(i = 0; i <gameNode.getNextLayer().size();i++){
				tempValMax = this.minimax(gameNode.getNextLayer().get(i),depth -1,false,alpha,beta);
				//
				bestScore= Math.max(bestScore,tempValMax);
			//	System.out.println("i is: " + i + " at depth " + depth );
			//	System.out.println("The best score for max is: "+bestScore);

				//alpha beta pruning
				alpha = Math.max(alpha,bestScore);
				if (beta <= alpha){
					System.out.println("Breaking");
					break;
				}
				//end for
				//stop iterating through all nodes here
			}
			return bestScore;
		} else {
			bestScore = 10000;


			for(j = 0; j <gameNode.getNextLayer().size();j++){

				tempValMin = this.minimax(gameNode.getNextLayer().get(j),depth -1,true,alpha,beta);

				bestScore= Math.min(bestScore,tempValMin);

				
				beta = Math.min(beta,bestScore);
				if (beta <= alpha){
					System.out.println("Breaking");
					break;
				}
				
			//	System.out.println("The best score for min is: "+bestScore);

			}
			//alpha beta pruning
			return bestScore;
			
			//end for
			//stop iterating through all nodes here			return bestScore;
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
		Board previousBoard = null;
		GameNode newLeaf;
		ArrayList<GameNode> list = new ArrayList<GameNode>();
		Board savedState = new Board(current.height,current.width, current.N), newState;
		savedState.board = this.copyBoard(current.getBoard());
		savedState.numOfDiscsInColumn = this.copyNumDiscsInColumn(current.numOfDiscsInColumn);
		if (depth == 0) {
			return null;
		}
		ArrayList<Integer> validMoves = this.findMoves(savedState);
		for (i = 0; i < validMoves.size(); i++) {
			newMove = new Move(validMoves.get(i), this.playerNum);
			newState = this.modifyState(savedState, newMove, this.playerNum);
			
			newLeaf = new GameNode(validMoves.get(i), savedState, this.createLayers(depth - 1, newState));
			list.add(newLeaf);
			previousBoard = newState;
		
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
		Board caliState = new Board(current.height,current.width, current.N);
		int[][] tempBoard = this.copyBoard(current.getBoard());
		caliState.board = tempBoard;
		caliState.numOfDiscsInColumn = this.copyNumDiscsInColumn(current.numOfDiscsInColumn);
		caliState.dropADiscFromTop(move.getCol(), player);
		return caliState;
	}

	int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[this.currentState.height][this.currentState.width];

		for (int i = 0; i < this.currentState.height; i++) {
			for (int j = 0; j < this.currentState.width; j++) {
				newBoard[i][j] = board[i][j];
			}
		}

		return newBoard;
	}

	int[] copyNumDiscsInColumn(int[] numDiscsInColumn) {
		int[] newColumns = new int[this.currentState.width];

		for (int j = 0; j < this.currentState.width; j++) {
			newColumns[j] = numDiscsInColumn[j];
		}


		return newColumns;

	}

}
