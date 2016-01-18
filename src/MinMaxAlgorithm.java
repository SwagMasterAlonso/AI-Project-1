import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class MinMaxAlgorithm {

	int playerNum;
	int opponentNum;
	Board currentState;
	Move opponentMove;
	Move friendlyMove;

	File file;
	FileOutputStream fos;
	PrintStream ps;

	public MinMaxAlgorithm(Board state, int playerNum, int opponent) {
		this.playerNum = playerNum;
		this.opponentNum = opponent;
		this.currentState = state;
		this.file = new File("err.txt");

		try {
			this.fos = new FileOutputStream(file);
		} catch (Exception e) {
			System.err.println(e);
		}

		this.ps = new PrintStream(fos);
		System.setErr(ps);
	}

	void getNextMove () {
		Random rand = new Random();
		//code for finding the next move
		//This is a random number generator that creates random moves
		int randomNum = rand.nextInt((6-1)+1) + 1;
		System.err.println("The column is :"+randomNum);
		this.friendlyMove = new Move(randomNum, 1);

	}

	void readMove(Move opponent){
		this.opponentMove = opponent;
		System.err.println("Reading opponent's move.");
		this.currentState.dropADiscFromTop(opponent.getCol(), this.opponentNum);

	}

	void writeMove() {
		this.currentState.dropADiscFromTop(this.friendlyMove.getCol(), this.playerNum);
		System.err.println("Writing our move.");
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

	void closeDebuggerStream() {
		try {
			this.fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
