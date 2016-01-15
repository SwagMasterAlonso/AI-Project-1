import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Player {
	private String name;

	protected int boardHeight, boardWidth, nPieces, playerTurn, timeLimit;
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public Player(String name) {
		this.name = name;
	}

	void sendName() {
		System.out.println(this.name);
	}

	void readConfig() throws IOException {
		int count = 0;


		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt()) {
			switch(count) {
				case 0:
					this.boardHeight = sc.nextInt();
					System.err.println("boardHeight is "+this.boardHeight);
					count++;
					break;
				case 1:
					this.boardWidth = sc.nextInt();
					System.err.println("boardWidth is "+this.boardWidth);
					count++;
					break;
				case 2:
					this.nPieces = sc.nextInt();
					System.err.println("nPieces is "+this.nPieces);
					count++;
					break;
				case 3:
					this.playerTurn = sc.nextInt();
					System.err.println("playerTurn is "+this.playerTurn);
					count++;
					break;
				case 4:
					this.timeLimit = sc.nextInt();
					System.err.println("timeLimit is "+this.timeLimit);
					count++;
					break;
				default:
					System.err.println("Should stop the while loop");
					break;
			}
		}

	}
	public String toString() {
		return this.name+" "+this.boardHeight+" "+this.boardWidth+" "+this.nPieces+" "+this.playerTurn+" "+this.timeLimit+" ";
	}
}
