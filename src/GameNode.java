import java.util.ArrayList;

/**
 * The purpose of the GameNode class is to create a game search tree, so we can
 * save game decisions for Connect-N moves.
 * @author jameschow, amartinez
 *@deprecated
 */
public class GameNode {
	/**The given move at a node of the tree.*/
	int moveNum;
	/**The given state at a node of the tree.*/
	Board state;
	/**The next layer of valid moves depending on the given state.*/
	ArrayList<GameNode> nextLayer;

	int depth;
	/**
	 * Constructor that creates a node of the game search tree.
	 * @param moveNum
	 * @param state
	 * @param nextMoves
	 */
	GameNode(int moveNum, Board state, ArrayList<GameNode> nextMoves,int depth) {
		this.moveNum = moveNum;
		this.state = state;
		this.nextLayer = nextMoves;
		this.depth=depth;
	}

	/**
	 * @return The move made at this node of the search tree.
	 */
	int getNum() {
		return this.moveNum;
	}

	/**
	 * @return The state of the board at this node of the search tree.
	 */
	Board getState() {
		return this.state;
	}

	/**
	 * @return The list of valid moves, i.e. the next depth of the search tree.
	 */
	ArrayList<GameNode> getNextLayer() {
		return this.nextLayer;
	}

}
