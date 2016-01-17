import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
		
		PrintWriter read = new PrintWriter("boobs.txt");
		
		

		//Scanner sc = new Scanner(System.in);
		String s = input.readLine();
	
		List<String> ls=Arrays.asList(s.split(" "));
			
		//read.println(ls.size());
		
		if(ls.size()==2){
			System.out.println(ls.get(0)+" "+ls.get(1));
			read.println(ls.get(0) +"1738");
			//read.close();
		}
		else if(ls.size()==1){
			System.out.println("game over!!!");
			//read.println("Hey");
			//read.close();
			read.println(this.boardHeight+" "+this.boardWidth+" "+this.nPieces+" "+this.playerTurn+" "+this.timeLimit);
			read.close();
			System.exit(0);

		}
		else if(ls.size()==5){
			//System.out.println("0 1");  //first move
		
			this.boardHeight = Integer.parseInt(ls.get(0));
			this.boardWidth = Integer.parseInt(ls.get(1));
			this.nPieces  = Integer.parseInt(ls.get(2));
			this.playerTurn = Integer.parseInt(ls.get(3));
			this.timeLimit = Integer.parseInt(ls.get(4));
		
		}
		else if(ls.size()==4){		//player1: aa player2: bb
			if (ls.get(1).equals(this.name)){
				this.playerTurn = 1;
			} else {
				this.playerTurn = 2;
			}
		
		}
		else{
			System.out.println("not what I want");
		}
	}		
	

	public String toString() {
		return this.name+" "+this.boardHeight+" "+this.boardWidth+" "+this.nPieces+" "+this.playerTurn+" "+this.timeLimit+" ";
	}
}
