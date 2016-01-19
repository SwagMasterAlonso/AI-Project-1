
import static org.junit.Assert.*;

import org.junit.Test;

public class testMinMax {

	@Test
	public void testCountNConnections() {
		Board state = new Board(6,7,4);
		MinMaxAlgorithm algo = new MinMaxAlgorithm(state, 1,2);
		algo.eval.setState(algo.currentState);
		assertEquals(algo.eval.countNConnectionsH(3, 1, 2),0);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(1,1);
		algo.currentState.dropADiscFromTop(2,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(1,1);
		algo.currentState.dropADiscFromTop(2,1);
		algo.currentState.dropADiscFromTop(3,1);
		algo.eval.setState(algo.currentState);
		assertEquals(algo.eval.countNConnectionsH(3, 1, 2),1);
	}
	@Test
	public void testCountNConnectionsVert() {
		Board newState = new Board(6,7,4);
		MinMaxAlgorithm algo = new MinMaxAlgorithm(newState, 1,2);
		algo.eval.setState(algo.currentState);
		assertEquals(algo.eval.countNConnectionsV(3, 1, 2), 0);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(1,1);
		algo.currentState.dropADiscFromTop(2,1);
		algo.currentState.dropADiscFromTop(3,1);
		algo.eval.setState(algo.currentState);
		assertEquals(algo.eval.countNConnectionsV(4, 1, 2), 1);
		assertEquals(algo.eval.countNConnectionsV(1, 1, 2), 3);
		assertEquals(algo.eval.countNConnectionsV(2, 1, 2), 0);
	}

	@Test
	public void testMoveEnumeration() {
		Board newState = new Board(6,7,4);
		MinMaxAlgorithm algo = new MinMaxAlgorithm(newState, 1,2);

	}
}
