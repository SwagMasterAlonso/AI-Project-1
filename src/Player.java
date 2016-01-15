import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		
		PrintWriter read = new PrintWriter("input.txt");


		//Scanner sc = new Scanner(System.in);
		String s = input.readLine();
		String x = input.readLine();
		String y = input.readLine();
		
//		while(sc.hasNextInt()) {
//			switch(count) {
//				case 0:
//					this.boardHeight =Integer.parseInt(sc.next());
//					System.err.println("boardHeight is "+this.boardHeight);
//					count++;
//					break;
//				case 1:
//					this.boardWidth = sc.nextInt();
//					System.err.println("boardWidth is "+this.boardWidth);
//					count++;
//					break;
//				case 2:
//					this.nPieces = sc.nextInt();
//					System.err.println("nPieces is "+this.nPieces);
//					count++;
//					break;
//				case 3:
//					this.playerTurn = sc.nextInt();
//					System.err.println("playerTurn is "+this.playerTurn);
//					count++;
//					break;
//				case 4:
//					this.timeLimit = sc.nextInt();
//					System.err.println("timeLimit is "+this.timeLimit);
//					count++;
//					break;
//				default:
//					System.err.println("Should stop the while loop");
//					break;
//			}
//		}
		read.println(s);
		read.println(x);
		read.print(y);

		read.close();
		//sc.close();
	}
	public String toString() {
		return this.name+" "+this.boardHeight+" "+this.boardWidth+" "+this.nPieces+" "+this.playerTurn+" "+this.timeLimit+" ";
	}
}
