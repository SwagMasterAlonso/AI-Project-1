import java.util.Scanner;

public class Player {
	private String name;

	protected int boardHeight, boardWidth, nPieces, playerTurn, timeLimit;

	public Player(String name) {
		this.name = name;
	}

	void sendName() {
		System.out.println(this.name);
	}

	void readConfig() {
		int count = 0;
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt()) {
			switch(count) {
				case 0:
					this.boardHeight = sc.nextInt();
					System.out.println("boardHeight is "+this.boardHeight);
					count++;
					break;
				case 1:
					this.boardWidth = sc.nextInt();
					System.out.println("boardWidth is "+this.boardWidth);
					count++;
					break;
				case 2:
					this.nPieces = sc.nextInt();
					System.out.println("nPieces is "+this.nPieces);
					count++;
					break;
				case 3:
					this.playerTurn = sc.nextInt();
					System.out.println("playerTurn is "+this.playerTurn);
					count++;
					break;
				case 4:
					this.timeLimit = sc.nextInt();
					System.out.println("timeLimit is "+this.timeLimit);
					count++;
					break;
				default:
					System.out.println("Should stop the while loop");
					break;
			}
		}

	}
}
