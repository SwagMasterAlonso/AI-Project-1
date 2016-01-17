import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter("config.txt");
		//create a player
		Player player = new Player("SwagMaster69");
		boolean firstSetup = true;
		int counter = 0;

		player.sendName();

		while (firstSetup) {
			player.readInput();
			
			//out.println(player);
			//out.close();
			//firstSetup = false;
		}

	}
}
