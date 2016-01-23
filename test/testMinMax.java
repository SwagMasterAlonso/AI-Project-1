
import static org.junit.Assert.*;

import org.junit.Test;

public class testMinMax {

//	@Test
//	public void testCountNConnections() {
//		Board state = new Board(6,7,4);
//		MinMaxAlgorithm algo = new MinMaxAlgorithm(state, 1,2);
//		algo.eval.setState(algo.currentState);
//		assertEquals(algo.eval.countNConnectionsH(3, 1, 2),0);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(1,1);
//		algo.currentState.dropADiscFromTop(2,1);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(1,1);
//		algo.currentState.dropADiscFromTop(2,1);
//		algo.currentState.dropADiscFromTop(3,1);
//		algo.eval.setState(algo.currentState);
//		assertEquals(algo.eval.countNConnectionsH(3, 1, 2),1);
//	}
//
//	@Test
//	public void testCountNConnectionsDiag() {
//		Board state = new Board(6,7,4);
//		MinMaxAlgorithm algo = new MinMaxAlgorithm(state, 1,2);
//		algo.eval.setState(algo.currentState);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(1,1);
//		algo.currentState.dropADiscFromTop(2,1);
//		algo.currentState.dropADiscFromTop(1,1);
//		algo.currentState.dropADiscFromTop(2,1);
//		algo.currentState.dropADiscFromTop(2,1);
//		algo.eval.setState(algo.currentState);
//		assertEquals(algo.eval.countNConnectionsDiag2(3, 1, 2),1);
//	}
//
//	@Test
//	public void testCountNConnectionsVert() {
//		Board newState = new Board(6,7,4);
//		MinMaxAlgorithm algo = new MinMaxAlgorithm(newState, 1,2);
//		algo.eval.setState(algo.currentState);
//		assertEquals(algo.eval.countNConnectionsV(3, 1, 2), 0);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(0,1);
//		algo.currentState.dropADiscFromTop(1,1);
//		algo.currentState.dropADiscFromTop(2,1);
//		algo.currentState.dropADiscFromTop(3,1);
//		algo.eval.setState(algo.currentState);
//		assertEquals(algo.eval.countNConnectionsV(4, 1, 2), 1);
//		assertEquals(algo.eval.countNConnectionsV(1, 1, 2), 3);
//		assertEquals(algo.eval.countNConnectionsV(2, 1, 2), 0);
//	}
//
//	//@Test
//	public void testMoveEnumeration() {
//		Board newState = new Board(6,7,4);
//		MinMaxAlgorithm algo = new MinMaxAlgorithm(newState, 1,2);
//		Move thisMove = new Move(1,1);
//		GameNode node; //= algo.createGameTree(1, algo.currentState, thisMove);
//
////		assertEquals(node.getNum(), 1);
////		for (int i = 0; i < 6; i++) {
////			assertEquals(node.getNextLayer().get(i).getNum(), i);
////		}
//
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 7; j+=2) {
//				newState.dropADiscFromTop(j,1);
//			}
//		}
//
//		node = algo.createGameTree(1, newState, thisMove);
//
//		assertEquals(node.getNextLayer().get(0).getNum(), 1);
//		assertEquals(node.getNextLayer().get(1).getNum(), 3);
//		assertEquals(node.getNextLayer().get(2).getNum(), 5);
//
//
//	}
//	@Test
//	public void testMinimax(){
//		Board newState = new Board(6,7,4);
//		MinMaxAlgorithm algo = new MinMaxAlgorithm(newState, 1,2);
//		Move thisMove = new Move(1,1);
//		GameNode node; //= algo.createGameTree(1, algo.currentState, thisMove);
//
//
////		for (int i = 0; i < 6; i++) {
////			for (int j = 0; j < 7; j+=2) {
////				newState.dropADiscFromTop(j,1);
////			}
////		}
//
//
//		newState.dropADiscFromTop(0, 1);
//		newState.dropADiscFromTop(1, 1);
//	//	newState.dropADiscFromTop(2,2);
//	//	newState.dropADiscFromTop(2, 1);
//	//	newState.dropADiscFromTop(3, 1);
//	///	newState.dropADiscFromTop(4, 1);
//	//	newState.dropADiscFromTop(5, 1);
//
//	//	newState.dropADiscFromTop(0, 1);
//	//	newState.dropADiscFromTop(1, 1);
//		algo.eval.setState(newState);
//
//		node = algo.createGameTree(1, newState, thisMove);
//
//
//		for(int i = 0; i < 6;i++){
//			for(int j = 0; j < 7; j++){
//				System.out.print(newState.board[i][j]+" ");
//			}
//			System.out.println("");
//		}
//
//
//		//assertEquals(algo.eval.countNConnectionsH(6, algo.playerNum, algo.opponentNum),1);
//		//assertEquals(algo.eval.countNConnectionsH(2, algo.playerNum, algo.opponentNum),1);
//
//
//		assertEquals(algo.minimax(node, 2, true, 0, 0),0);
//
//	}

	@Test
	public void testMinimax2(){
		Board newState = new Board(4,5,4);
		MinMaxAlgorithm algo;
		Move thisMove = new Move(2,1);
		GameNode node;
		Move bestMove = null;

	
		//newState.dropADiscFromTop(2,2);
		//newState.dropADiscFromTop(2,2);
		//newState.dropADiscFromTop(2,2);
		newState.dropADiscFromTop(3,1);
		newState.dropADiscFromTop(3,1);
		newState.dropADiscFromTop(3,1);
		newState.dropADiscFromTop(0,2);
		newState.dropADiscFromTop(0,2);
		newState.dropADiscFromTop(0,2);


		
		
		algo = new MinMaxAlgorithm(newState, 1,2);
		algo.eval.setState(newState);

		//node = algo.createGameTree(2, newState, thisMove);


		for(int i = 0; i < 4;i++){
			for(int j = 0; j < 5; j++){
				System.out.print(newState.board[i][j]+" ");
			}
			System.out.println("");
		}


		//assertEquals(algo.eval.countNConnectionsH(6, algo.playerNum, algo.opponentNum),1);
		//assertEquals(algo.eval.countNConnectionsH(2, algo.playerNum, algo.opponentNum),1);


		//assertEquals(algo.minimax(node, 2, true, 0, 0),0);
		algo.getNextMove();
		bestMove = algo.friendlyMove;
		newState.dropADiscFromTop(bestMove.colNum, 1);
		for(int i = 0; i < 4;i++){
			for(int j = 0; j < 5; j++){
				System.out.print(newState.board[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println(bestMove);

	}
}
