import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
 

class Main {

	public static void main(String[] args) throws IOException {

		//create a random number to add to our player
		//used to run two players of same jar against each other
		Random rand = new Random();
		
		
		//generate our new player
		Player player = new Player("SwagMaster"+rand.nextInt((1000-1)+1));

		
		//send our name to the referee
		player.sendName();

		
		//begin polling and sending data until system exit
		while (true) {
			player.readInput();

		
		}

	}
}
