import java.util.Scanner;

public class Player {
	private String name;

	protected int boardHeight, boardWidth, nPieces, playerTurn, timeLimit;

	public Player(String name) {
		this.name = name;
	}

	void sendName(String name) {
		System.out.println(this.name);
	}

	void readConfig() {
		int count = 0;
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt()) {
			switch(count) {
				case 0:
					this.boardHeight = sc.nextInt();
					count++;
					break;
				case 1:
					this.boardWidth = sc.nextInt();
					count++;
					break;
				case 2:
					this.nPieces = sc.nextInt();
					count++;
					break;
				case 3:
					this.playerTurn = sc.nextInt();
					count++;
					break;
				case 4:
					this.timeLimit = sc.nextInt();
					count++;
					break;
				default:
					System.err.println("Should stop the while loop");
					break;
			}
		}

	}
}
