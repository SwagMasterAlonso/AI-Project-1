import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


/**
 * The purpose of this class is to communicate with the referre, reading
 * in input( opponent moves/ game information) and output (our moves/ sending game info.).
 * @author jameschow, amartinez
 *
 */
public class Player {
	private String name;

	protected int boardHeight, boardWidth, nPieces, whoGoesFirst, timeLimit,isPlayer;
	private Board board; //initial board
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	MinMaxAlgorithm algo = null;


	public Player(String name) {
		this.name = name;
		this.board = null;
	}

	void sendName() {
		System.out.println(this.name);
	}

	void readInput() throws IOException {

		//PrintWriter read = new PrintWriter("boobs.txt");



		//Scanner sc = new Scanner(System.in);
		String s = input.readLine();

		List<String> ls=Arrays.asList(s.split(" "));

		//read.println(ls.size());

		if(ls.size()==2){
			//System.out.println(ls.get(0)+" "+ls.get(1));
			Move move = new Move(Integer.parseInt(ls.get(0)),Integer.parseInt(ls.get(1)));

			this.algo.readMove(move);

			this.algo.getNextMove();


			//create game tree
			//run eval function on entire tree
			//run minimax on tree
			//return the next move


			this.algo.writeMove();
		}
		else if(ls.size()==1){

			System.out.println("game over!!!");
			System.exit(0);

			//read.println("Hey");
			//read.close();

			//			for(int i = 0; i < this.boardHeight;i++){
			//				for(int j = 0; j < this.boardWidth;j++){
			//					read.print(this.board.board[i][j]);
			//					read.flush();
			//				}
			//				read.println("");
			//			}
			//			read.close();


		}
		else if(ls.size()==5){
			//System.out.println("0 1");  //first move

			this.boardHeight = Integer.parseInt(ls.get(0));
			this.boardWidth = Integer.parseInt(ls.get(1));
			this.nPieces  = Integer.parseInt(ls.get(2));
			this.whoGoesFirst = Integer.parseInt(ls.get(3));
			this.timeLimit = Integer.parseInt(ls.get(4));
			this.board = new Board(this.boardHeight,this.boardWidth,this.nPieces);


			if(this.isPlayer == 1){
				algo = new MinMaxAlgorithm(this.board,this.isPlayer,2,this.timeLimit);
			} else {
				algo = new MinMaxAlgorithm(this.board,this.isPlayer,1,this.timeLimit);
			}

			if(this.isPlayer == this.whoGoesFirst){
				this.algo.getNextMove();
				this.algo.writeMove();

			}


		}
		else if(ls.size()==4){		//player1: aa player2: bb
			if (ls.get(1).equals(this.name)){
				this.isPlayer = 1;
			} else {
				this.isPlayer = 2;
			}

		}
		else{
			System.out.println("not what I want");
		}
	}


	public String toString() {
		return this.name+" "+this.boardHeight+" "+this.boardWidth+" "+this.nPieces+" "+this.whoGoesFirst+" "+this.timeLimit+" ";
	}
}
