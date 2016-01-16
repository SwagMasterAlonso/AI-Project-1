import java.util.Random;

public class MinMaxAlgorithm {

	Board currentState;
	Move opponentMove;
	Move friendlyMove;

	public MinMaxAlgorithm(Board state) {
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
	}

	void writeMove() {
		System.out.println(this.friendlyMove.toString());
	}

}
