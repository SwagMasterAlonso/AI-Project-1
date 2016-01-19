import java.util.ArrayList;

public class GameNode {
	int moveNum;
	Board state;
	ArrayList<GameNode> nextLayer;

	GameNode(int moveNum, Board state, ArrayList<GameNode> nextMoves) {
		this.moveNum = moveNum;
		this.state = state;
		this.nextLayer = nextMoves;
	}

	int getNum() {
		return this.moveNum;
	}

	Board getState() {
		return this.state;
	}

	ArrayList<GameNode> getNextLayer() {
		return this.nextLayer;
	}

}
