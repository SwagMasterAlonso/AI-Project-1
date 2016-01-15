import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter("config.txt");
		//create a player
		Player player = new Player("SwagMaster69");
		boolean firstSetup = true;


		player.sendName();

		while (firstSetup) {
			//out.println(player);
			player.readConfig();
			out.close();
			firstSetup = false;
		}

	}
}
