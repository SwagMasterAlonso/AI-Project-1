import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.*;
import java.util.*;

/**
 * The purpose of this class is to execute the MinMaxAlgorithm with alpha-beta pruning.
 * Here, the algorithm searches through possible game moves and evaluates the state of the board
 * at that depth.
 * @author amartinez, yychow
 *
 */
public class MinMaxAlgorithm {
	/**The number of the our player.*/
	int playerNum;
	/**The number of the opponent.*/
	int opponentNum;
	/**The current state of the board.*/
	Board currentState;
	/**The move the opponent makes.*/
	Move opponentMove;
	/**The timer that tells the player when time is up.*/
	Timer autoTimer=null;
	/**The move that the player wants to make.*/
	Move friendlyMove;
	/**The class used for printing debug messages.*/
	Debugger debugger;
	/**The class used for evaluate the state of the board.*/
	Heuristic eval;
	/***/
	static int currDepth =0;
	/***/
	static int tempDepth;
	/**The temporary max value at some modified state of the board.*/
	int tempValMax;
	/**The temporary min value at some modified state of the board.*/
	int tempValMin;
	/***/
	int score = -100000;
	/**The time limit that the player has to make a move.*/
	int timeLimit;
	/**Max depth that the algorithm searches.*/
	int maxDepth = 3;
	/**The best result from the minmax algorithm.*/
	int colBest;
	/**The Bestscore for a modified state from minmax recursions.*/
	int bestScore = -1000;
	/**The worst score for a modified state from minmax recursions.*/
	int worstScore=1000;
	/**The best move to take for a given state of the board.*/
	int bestMove;


	/**
	 * Constructor for the class that creates a MinMaxAlgorithm object that can run
	 * the algorithm, search for the best move, and send the best move to the player.
	 * @param state
	 * @param playerNum
	 * @param opponent
	 * @param timeLimit
	 */
	public MinMaxAlgorithm(Board state, int playerNum, int opponent,int timeLimit) {
		this.playerNum = playerNum;
		this.opponentNum = opponent;
		this.currentState = state;
		this.eval = new Heuristic();
		this.debugger = new Debugger();
		this.timeLimit = timeLimit;
	}


	void getNextMove () {
		ArrayList <Integer> validMoves = new ArrayList<Integer>();
		Move bestMove = null;
		int tempScore = -10000;
		GameNode tree = null;
		Move move = null;
		int i;





	}
	//	Random rand = new Random();
	//code for finding the next move
	//This is a random number generator that creates random moves
	//		int randomNum = rand.nextInt((6-1)+1) + 1;
	//		this.debugger.writeToDebug("col is: "+randomNum);
	//		this.friendlyMove = new Move(randomNum, 1);
	//	validMoves = findMoves(this.currentState);
	//Collections.reverse(validMoves);

	//	countDown(this.timeLimit-3);

	//	for(i = 0; i < validMoves.size();i++){


	/////System.out.println("");
	/////System.out.println("");
	/////System.out.println("Exploring validMoves at: " + i);
	//	/////System.out.println(tempScore);
	//	/////System.out.println(score);
	/////System.out.println("");
	/////System.out.println("");

	//			if (validMoves.get(i) > this.currentState.width) {
	//				move = new Move((validMoves.get(i)-10) , 0);
	//			} else  {
	//				move = new Move(validMoves.get(i), 1);
	//			}



	//			tree = createGameTree(3,this.currentState,move);
	//			tempScore = this.minimax(tree, 3, true, -10000, 10000);
	//			//	score= Math.max(score, tempScore);
	//
	//			if(tempScore > score){
	//				///////System.out.println("Best Move is: "+bestMove);
	//				/////System.out.println("Best Depth is: "+tempDepth);
	//				bestMove = move;
	//				//				/////System.out.println("");
	//				//				/////System.out.println(tempScore);
	//				//				/////System.out.println(score);
	//				//				/////System.out.println("Best Move is: "+bestMove);
	//				currDepth = tempDepth;
	//				score = tempScore;
	//				//				/////System.out.println("Best score is: "+score);
	//				//				/////System.out.println("");
	//				//	/////System.out.println("Col is " +bestMove.colNum);
	//			} else {
	//				/////System.out.println("Lower");
	//				/////System.out.println("Temp Depth didnt work was: " + tempDepth);
	//				tempDepth = -1;
	//				currDepth = 0;
	//
	//
	//			}
	//			currDepth = 0;
	//
	//			tempDepth = -1;

	//	}
	//		this.autoTimer.cancel();
	//		this.friendlyMove = bestMove;
	//	}

	/**
	 * Method that takes in the opponents move and modifies the internal
	 * board state for the algorithm to keep track of.
	 * @param opponent, Move of the opponent.
	 */
	void readMove(Move opponent){
		this.opponentMove = opponent;
		//Determines if opponent's move is a drop or a pop and modifies the board state accordingly.
		if(opponentMove.isDrop){
			this.currentState.dropADiscFromTop(opponent.getCol(), this.opponentNum);
		}
		else {
			this.currentState.removeADiscFromBottom(opponent.getCol());
		}
	}

	/**
	 * Method that writes the move to standard output and updates the current state of the
	 * board.
	 */
	void writeMove() {

		/*Modifies the current state of the board accordingly.*/
		if(this.friendlyMove.isDrop){
			this.currentState.dropADiscFromTop(this.friendlyMove.getCol(), this.playerNum);
		}
		else {
			this.currentState.removeADiscFromBottom(this.friendlyMove.getCol());
		}
		System.out.println(this.friendlyMove.toString());
	}



	//	int minimax(GameNode gameNode,int depth, boolean isMax,int alpha, int beta) {
	//		int i,j ,bestScore = 0;
	//
	//		//Move newMove;
	//
	//		//friendly move should be up to date
	//		//GameNode tree = this.createGameTree(depth, this.currentState,this.friendlyMove);
	//
	//		if (depth == 0 || gameNode.getNextLayer() ==null ) {
	//
	//			this.eval.setState(gameNode.getState());
	//		//	/////System.out.println("Eval is: " +  eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum));
	//			return eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum);
	//
	//		} else if(isMax) {
	//			bestScore = -10000;
	//
	//			//iterate through all nodes here
	//
	//
	//			for(i = 0; i <gameNode.getNextLayer().size();i++){
	//				tempValMax = this.minimax(gameNode.getNextLayer().get(i),depth -1,false,alpha,beta);
	//				//
	//
	//
	//				if(tempValMax > bestScore){
	//					tempDepth = gameNode.depth;
	//				}
	//				bestScore= Math.max(bestScore,tempValMax);
	//			//	/////System.out.println("i is: " + i + " at depth " + depth );
	//			//	/////System.out.println("The best score for max is: "+bestScore);
	//
	//				//alpha beta pruning
	//				alpha = Math.max(alpha,bestScore);
	//				if (beta <= alpha){
	//					/////System.out.println("Breaking");
	//					break;
	//				}
	//				//end for
	//				//stop iterating through all nodes here
	//			}
	//			return bestScore;
	//		} else {
	//			bestScore = 10000;
	//
	//
	//			for(j = 0; j <gameNode.getNextLayer().size();j++){
	//
	//				tempValMin = this.minimax(gameNode.getNextLayer().get(j),depth -1,true,alpha,beta);
	//
	//				if(tempValMin < bestScore){
	//					tempDepth = gameNode.depth;
	//				}
	//
	//				bestScore= Math.min(bestScore,tempValMin);
	//
	//
	//				beta = Math.min(beta,bestScore);
	//				if (beta <= alpha){
	//					/////System.out.println("Breaking");
	//					break;
	//				}
	//
	//			//	/////System.out.println("The best score for min is: "+bestScore);
	//
	//			}
	//			//alpha beta pruning
	//			return bestScore;
	//
	//			//end for
	//			//stop iterating through all nodes here			return bestScore;
	//		}
	//	}



	//	int minimax(int depth, boolean isMax,int alpha,int beta){
	//
	//
	//		int i,j;
	//		int tempScore;
	//
	//
	//		if(depth == maxDepth){
	//			System.out.println("At Max Depth: "+depth);
	//			this.eval.setState(this.currentState);
	//			return eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum);
	//		}
	//
	//		ArrayList<Integer> validMoves = this.findMoves(this.currentState);
	//		for(i = 0; i < validMoves.size();i++){
	//
	//			if(!this.currentState.canMakeMove(i)){
	//				continue;
	//			}
	//
	//			if(isMax){
	//			currentState.dropADiscFromTop(i,1);
	//			System.out.println("Max Move is at "+i);
	//
	//
	//
	//			for(int x = 0; x < 3;x++){
	//				for(int y = 0; y < 3; y++){
	//					System.out.print(currentState.board[x][y]+" ");
	//				}
	//				System.out.println("");
	//			}
	//			System.out.println("");
	//
	//			tempScore = minimax(depth-1,false,alpha,beta);
	//			System.out.println("Score at " +i+" is "+tempScore);
	//
	//
	//
	//			bestScore = Math.max(tempScore, bestScore);
	//
	//
	//			if(this.currentState.isConnectN() == 1){
	//				System.out.println("Is connect N");
	//				System.out.println("Best Column is " + colBest);
	//				bestScore = bestScore*2+1000*depth;
	//				System.out.println(depth);
	//				System.out.println(bestScore);
	//				//colBest =i;
	//				//return colBest;
	//
	//			}
	//
	//
	//			if(tempScore > bestScore){
	//				bestScore = tempScore;
	//				colBest =i;
	//
	//			}
	//
	//			if(depth == 0){
	//				System.out.println("In 0");
	//				colBest = i;
	//				break;
	//				//System.out.println("Best Column is " + colBest);
	//			}
	//		} else {
	//			currentState.dropADiscFromTop(i,2);
	//			System.out.println("Min Move is at "+ i);
	//
	//			for(int f = 0; f < 3;f++){
	//				for(int g = 0; g < 3; g++){
	//					System.out.print(currentState.board[f][g]+" ");
	//				}
	//				System.out.println("");
	//			}
	//
	//
	//			System.out.println("");
	//			tempScore = minimax(depth-1,true,alpha,beta);
	//			worstScore = Math.min(tempScore, worstScore);
	//			System.out.println("Depth at min is: " + depth);
	//
	//		}
	//			//System.out.println("Removing move at: " +i);
	//			///currentState.removeMove(i);
	//		}
	//
	//
	//		if(isMax){
	//			System.out.println("Best Column at end is " + colBest);
	//			return bestScore;
	//		} else {
	//			System.out.println("Best Column at end is " + colBest);
	//			return worstScore;
	//		}
	//	}

	/**
	 * Parent method that calls helper to run minmax method to find the best available move.
	 * @return, The column of the best valid move to place a disk.
	 */
	int getMaxMoveColumn(){

		Board caliState = new Board(this.currentState.height,this.currentState.width, this.currentState.N);
		int[][] tempBoard = this.copyBoard(this.currentState.getBoard());
		caliState.board = tempBoard;
		caliState.numOfDiscsInColumn = this.copyNumDiscsInColumn(this.currentState.numOfDiscsInColumn);

		/**Iterates through all the valid moves given the current state of the board.*/
		for(int i = 0; i < this.currentState.width;i++){
			System.out.println("STARTING : "+i);



			System.out.println("BOARD STATE");
			for(int f = 0; f < 3;f++){
				for(int g = 0; g < 3; g++){
					System.out.print(currentState.board[f][g]+" ");
				}
				System.out.println("");
			}


			if(this.currentState.canDropADiscFromTop(i)){
				System.out.println("IN : "+i);
				//int finVal = getMaxMove(i);
				//int finVal = this.minimax(maxDepth, true, -100, 100);

				/**If can make move, find the best move for max.*/
				int finVal = this.getMaxMove(i);
				System.out.println("Final Value is: "+finVal);
				if(finVal > bestScore){
					/**Stores the best move in bestScore*/
					bestScore = finVal;
					bestMove = i;
				}


			} else {
				System.out.println("Cant make a move");
			}
			System.out.println("FINISHING : "+i);

		}
		System.out.println(bestMove);
		return bestMove;
	}


	/**
	 * Method the runs the minmax algorithm beginning algorithm by running
	 * it with min.
	 * @param col, The valid column to put a disk.
	 * @return, The best value that min produces.
	 */
	int getMaxMove(int col){

		this.currentState.dropADiscFromTop(col, this.opponentNum);

		int tempScore = minimax(maxDepth,false,-10000,10000);

		this.currentState.removeMove(col);

		return tempScore;
	}



	/**
	 * This function should first search all the valid moves of the board.
	 * Then recursively goes to greater depth to find the nth valid move given the first valid move.
	 * Upon reaching the last depth, returns an evaluation value for the state at this level.
	 * Always returns the best-worst move given the current state.
	 *
	 * @param depth, Current depth.
	 * @param isMax, True or false depending on whether max is running or min is running.
	 * @param alpha, Best move for max.
	 * @param beta, Best move for min.
	 * @return Either alpha or beta for pruning purposes.
	 */
	int minimax(int depth, boolean isMax, int alpha, int beta){

		if(depth == 0){
			/**Upon reaching the bottom of the depth, we evaluate the current state
			 * depending upon the changes to the board.
			 * */
			System.out.println("Evaling");
			this.eval.setState(this.currentState);
			return eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum);
		}



		if(isMax){
			/**Running with max*/
			for(int i = 0; i < this.currentState.width;i++){
				System.out.println("STARTING : "+i);

				/**Given that a disc can be dropped from a column.*/
				if(this.currentState.canDropADiscFromTop(i)){
					/**Make move and update the board.*/
					this.currentState.dropADiscFromTop(i, this.opponentNum);
					/**Recurse to the next layer of minmax, min.*/
					int tempScore = minimax(depth - 1,false,alpha,beta);
					System.out.println("Max");
					for(int f = 0; f < 3;f++){
						for(int g = 0; g < 3; g++){
							System.out.print(currentState.board[f][g]+" ");
						}
						System.out.println("");
					}
					/**saves the best column if best move for max.*/
					if(tempScore > alpha){
						int bestCol = i;
						System.out.println("Best Col is: "+bestCol);
					} else {
						System.out.println("Skipping:");
					}

					/**Stores the max to alpha.*/
					alpha = Math.max(alpha, tempScore);
					System.out.println("Best Score For Max is: "+ alpha);

					/**Undoes the move that modifies the move before recursing back
					 * up the tree.*/
					this.currentState.removeMove(i);

					/**if-statement to prune irrelevant moves.*/
					if(beta<=alpha){
						break;
					}


				} else {
					System.out.println("CANT DROP");
				}


				System.out.println("FINISHING : "+i);

			}
			return alpha;

		} else {
			for(int i = 0; i < this.currentState.width;i++){


				if(this.currentState.canDropADiscFromTop(i)){
					/***
					 * If the move is valid, make that move, and update the board.
					 */
					this.currentState.dropADiscFromTop(i, this.playerNum);

					/**Recurses to the next layer of minmax, max
					 * and storing the best move for min.*/
					int tempScore = minimax(depth - 1,true,alpha,beta);
					System.out.println("Min");
					for(int f = 0; f < 3;f++){
						for(int g = 0; g < 3; g++){
							System.out.print(currentState.board[f][g]+" ");
						}
						System.out.println("");
					}
					/**Stores the minimum value to beta.*/
					beta = Math.min(beta,tempScore);

					System.out.println("Best Score For Min is: "+ beta);

					/**Undoes the move that modifies the move before recursing back
					 * up the tree.*/
					this.currentState.removeMove(i);

					/**Prunes if beta is greater than or equal to alpha.*/
					if(beta<=alpha){
						break;
					}


				}



			}
			return beta;
		}

	}



	/**
	 * Deprecated method where we tried to encapsulate the game tree as a tree data structure.
	 * Returns the head of the game tree.
	 * @param depth, Suggested depth of the game tree.
	 * @param givenState, Provided state of game.
	 * @param move, Next move to make.
	 * @return, A game node.
	 */
	GameNode createGameTree(int depth, Board givenState, Move move) {
		Move newMove = move;
		ArrayList<GameNode> nextMoves = createLayers(depth, this.modifyState(givenState, newMove, this.playerNum));

		GameNode tree = new GameNode(newMove.getCol(),givenState, nextMoves,depth);

		return tree;
	}

	/**
	 * Deprecated method that recursively create the next layer of the game tree by creating
	 * game nodes for each of the valid moves.
	 * @param depth
	 * @param current
	 * @return
	 */
	private ArrayList<GameNode> createLayers(int depth, Board current) {
		Move newMove;
		int i;
		GameNode newLeaf;
		ArrayList<GameNode> list = new ArrayList<GameNode>();
		/**Copies the board to prevent modifying the current board.*/
		Board savedState = new Board(current.height,current.width, current.N), newState;
		savedState.board = this.copyBoard(current.getBoard());
		savedState.numOfDiscsInColumn = this.copyNumDiscsInColumn(current.numOfDiscsInColumn);

		/**If the method has reached zero, stop node generation.*/
		if (depth == 0) {
			return null;
		}
		/**Finds the vaid moves given the board state.*/
		ArrayList<Integer> validMoves = this.findMoves(savedState);

		/**Iterates through the board and creates the next layer of the game tree.*/
		for (i = 0; i < validMoves.size(); i++) {
			if (validMoves.get(i) > this.currentState.width) {
				newMove = new Move((validMoves.get(i)-10) , 0);
			} else  {
				newMove = new Move(validMoves.get(i), 1);
			}
			/**Modify the baord state given the valid move*/
			newState = this.modifyState(savedState, newMove, this.playerNum);
			/**Create the next layer.*/
			newLeaf = new GameNode(validMoves.get(i), newState, this.createLayers(depth - 1, newState),depth-1);
			list.add(newLeaf);

		}
		return list;
	}

	/**
	 * Method that, given the state of the board, finds the valid moves
	 * like pop or drop a disk.
	 * @param state, Given board.
	 * @return, List of valid moves.
	 */
	ArrayList<Integer> findMoves(Board state) {
		int i;
		ArrayList<Integer> openList = new ArrayList<Integer>();

		/**Iterates through each column checking if we can
		 * drop a disk in that column*/
		for (i = 0; i < state.width; i++) {
			if (state.canDropADiscFromTop(i)) {
				openList.add(i);
			}
			/***Checks if we can also pop a disk at that column
			 */
			//			if (state.canRemoveADiscFromBottom(i, this.playerNum)) {
			//				openList.add(i + 10);
			//			}
		}

		return openList;
	}
	/**
	 * Returns a board updated with the move. Layers of the game tree
	 * must update their given states so that they can accurately do valid moves.
	 * @param current
	 * @param move
	 * @param player
	 *
	 */
	Board modifyState(Board current, Move move, int player) {
		Board caliState = new Board(current.height,current.width, current.N);
		/**Copies the board as necessary.*/
		int[][] tempBoard = this.copyBoard(current.getBoard());
		caliState.board = tempBoard;
		caliState.numOfDiscsInColumn = this.copyNumDiscsInColumn(current.numOfDiscsInColumn);

		/**Updates the board depending on the given move.*/
		if (move.isDrop) {
			caliState.dropADiscFromTop(move.getCol(), player);
		} else if (move.isPop) {
			caliState.removeADiscFromBottom(move.getCol());
		}

		return caliState;
	}

	/**
	 * Methods that solves referencing to board objects. It copies each cell of the board manually.
	 * Resolved an issue where a move in the game tree modified the current state of the board.
	 * @param board, The multi-dimensional array to copy.
	 * @return, The copied array.
	 */
	int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[this.currentState.height][this.currentState.width];

		for (int i = 0; i < this.currentState.height; i++) {
			for (int j = 0; j < this.currentState.width; j++) {
				newBoard[i][j] = board[i][j];
			}
		}

		return newBoard;
	}

	/**
	 * Methods that solves referencing to board objects.It copies the number of discs in one column.
	 * Resolved an issue where a move in the game tree modified the current state of the board.
	 * @param numDiscsInColumn, The  array to copy.
	 * @return, The copied array.
	 */
	int[] copyNumDiscsInColumn(int[] numDiscsInColumn) {
		int[] newColumns = new int[this.currentState.width];

		for (int j = 0; j < this.currentState.width; j++) {
			newColumns[j] = numDiscsInColumn[j];
		}


		return newColumns;

	}

	private void countDown(int seconds){
		if (seconds > 0) {
			if (this.autoTimer != null) {
				this.autoTimer.cancel();
			}
			this.autoTimer = new Timer();
			this.autoTimer.schedule(new TimerTask() {
				public void run() {
					/////System.out.println("Time Out!");


				}
			}, seconds * 1000);
		}
	}

}
