import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
 

class Main {

	public static void main(String[] args) throws IOException {
		//PrintWriter out = new PrintWriter("config.txt");
		//create a player
		Random rand = new Random();

		Player player = new Player("SwagMaster"+rand.nextInt((1000-1)+1));
		boolean firstSetup = true;

		player.sendName();

		while (firstSetup) {
			player.readInput();

			//out.println(player);
			//out.close();
			//firstSetup = false;
		}

	}
}
