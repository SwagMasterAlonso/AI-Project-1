import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//create a player
		Player player = new Player("SwagMaster69");
		boolean firstSetup = true;

		player.sendName();

		while (firstSetup) {
			player.readConfig();
			firstSetup = false;
		}
	}
}
