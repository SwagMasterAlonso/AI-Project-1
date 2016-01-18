
import static org.junit.Assert.*;

import org.junit.Test;

public class testMinMax {

	@Test
	public void testCountNConnections() {
		Board state = new Board(6,7,4);
		MinMaxAlgorithm algo = new MinMaxAlgorithm(state, 1,2);
		assertEquals(algo.countNConnectionsH(3, 1),0);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(1,1);
		algo.currentState.dropADiscFromTop(2,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(1,1);
		algo.currentState.dropADiscFromTop(2,1);
		algo.currentState.dropADiscFromTop(3,1);
		assertEquals(algo.countNConnectionsH(3, 1),1);
	}
	@Test
	public void testCountNConnectionsVert() {
		Board state = new Board(6,7,4);
		MinMaxAlgorithm algo = new MinMaxAlgorithm(state, 1,2);
		assertEquals(algo.countNConnectionsV(3, 1),0);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(0,1);
		algo.currentState.dropADiscFromTop(1,1);
		algo.currentState.dropADiscFromTop(2,1);
		algo.currentState.dropADiscFromTop(3,1);
		assertEquals(algo.countNConnectionsV(4, 1),1);
		assertEquals(algo.countNConnectionsV(1, 1),3);
		assertEquals(algo.countNConnectionsV(2, 1),0);
	}
}
