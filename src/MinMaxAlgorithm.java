import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.*;
import java.util.*;
public class MinMaxAlgorithm {

	int playerNum;
	int opponentNum;
	Board currentState;
	Move opponentMove;
	Timer autoTimer=null;
	Move friendlyMove;
	Debugger debugger;
	Heuristic eval;
	static int currDepth =0;
	static int tempDepth;
	int tempValMax;
	int tempValMin;
	int score = -100000;
	int timeLimit;
	int maxDepth = 3;
	int colBest;
	int bestScore = -1000;
	int worstScore=1000;
	int bestMove;


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

	void readMove(Move opponent){
		this.opponentMove = opponent;
		if(opponentMove.isDrop){
			this.currentState.dropADiscFromTop(opponent.getCol(), this.opponentNum);
		}
		else {
			this.currentState.removeADiscFromBottom(opponent.getCol());
		}
	}

	void writeMove() {

		if(this.friendlyMove.isDrop){
			this.currentState.dropADiscFromTop(this.friendlyMove.getCol(), this.playerNum);
		}
		else {
			this.currentState.removeADiscFromBottom(this.friendlyMove.getCol());
		}
		System.out.println(this.friendlyMove.toString());
	}

	/**
	 * This function should first search all the valid moves of the board
	 * Then call a helper function to find the nth valid move given the first valid move
	 * Then
	 */


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


	int getMaxMoveColumn(){
		
		Board caliState = new Board(this.currentState.height,this.currentState.width, this.currentState.N);
		int[][] tempBoard = this.copyBoard(this.currentState.getBoard());
		caliState.board = tempBoard;
		caliState.numOfDiscsInColumn = this.copyNumDiscsInColumn(this.currentState.numOfDiscsInColumn);
		
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
				int finVal = this.getMaxMove(i);
				System.out.println("Final Value is: "+finVal);
				if(finVal > bestScore){
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



	int getMaxMove(int col){

		this.currentState.dropADiscFromTop(col, this.opponentNum);

		int tempScore = minimax(maxDepth,false,-10000,10000);

		this.currentState.removeMove(col);

		return tempScore;
	}



	int minimax(int depth, boolean isMax, int alpha, int beta){

		if(depth == 0){
			System.out.println("Evaling");
			this.eval.setState(this.currentState);
			return eval.evaluate(this.currentState.N, this.playerNum, this.opponentNum);
		}



		if(isMax){
			for(int i = 0; i < this.currentState.width;i++){
				System.out.println("STARTING : "+i);

				
				if(this.currentState.canDropADiscFromTop(i)){

					this.currentState.dropADiscFromTop(i, this.opponentNum);
					int tempScore = minimax(depth - 1,false,alpha,beta);
					System.out.println("Max");
					for(int f = 0; f < 3;f++){
						for(int g = 0; g < 3; g++){
							System.out.print(currentState.board[f][g]+" ");
						}
						System.out.println("");
					}
					
					if(tempScore > alpha){
						int bestCol = i;
						System.out.println("Best Col is: "+bestCol);
					} else {
						System.out.println("Skipping:");
					}
					
					
					alpha = Math.max(alpha, tempScore);
					System.out.println("Best Score For Max is: "+ alpha);

					


					this.currentState.removeMove(i);

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

					this.currentState.dropADiscFromTop(i, this.playerNum);

					int tempScore = minimax(depth - 1,true,alpha,beta);
					System.out.println("Min");
					for(int f = 0; f < 3;f++){
						for(int g = 0; g < 3; g++){
							System.out.print(currentState.board[f][g]+" ");
						}
						System.out.println("");
					}
					beta = Math.min(beta,tempScore);

					System.out.println("Best Score For Min is: "+ beta);


					
					
					this.currentState.removeMove(i);
					
					if(beta<=alpha){
						break;
					}


				}



			}
			return beta;
		}

	}




	GameNode createGameTree(int depth, Board givenState, Move move) {
		Move newMove = move;
		ArrayList<GameNode> nextMoves = createLayers(depth, this.modifyState(givenState, newMove, this.playerNum));

		GameNode tree = new GameNode(newMove.getCol(),givenState, nextMoves,depth);

		return tree;
	}

	private ArrayList<GameNode> createLayers(int depth, Board current) {







		Move newMove;
		int i;
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
			if (validMoves.get(i) > this.currentState.width) {
				newMove = new Move((validMoves.get(i)-10) , 0);
			} else  {
				newMove = new Move(validMoves.get(i), 1);
			}
			newState = this.modifyState(savedState, newMove, this.playerNum);
			newLeaf = new GameNode(validMoves.get(i), newState, this.createLayers(depth - 1, newState),depth-1);
			list.add(newLeaf);
			/////System.out.println("");


			///////System.out.println("At depth: "+depth);

			for(i = 0; i < 6;i++){
				for(int j = 0; j < 7; j++){
					/////System.out.print(current.board[i][j]+" ");
				}
				/////System.out.println("");
			}

		}


		return list;
	}

	ArrayList<Integer> findMoves(Board state) {
		int i;
		ArrayList<Integer> openList = new ArrayList<Integer>();

		for (i = 0; i < state.width; i++) {
			if (state.canDropADiscFromTop(i)) {
				openList.add(i);
			}
			//			if (state.canRemoveADiscFromBottom(i, this.playerNum)) {
			//				openList.add(i + 10);
			//			}
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

		if (move.isDrop) {
			caliState.dropADiscFromTop(move.getCol(), player);
		} else if (move.isPop) {
			caliState.removeADiscFromBottom(move.getCol());
		}

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
