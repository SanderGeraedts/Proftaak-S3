package GameLogic;


import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;

public class Game {

	private int gameID;
	private int gameState;

	/**
	 * 
	 * @param gameID
	 * @param gameState
	 */
	public Game(int gameID, int gameState) {
		this.gameID = gameID;
                this.gameState = gameState;
	}
        
        
        /**
         * Add a player to the game.
         */
	public void addPlayer() {
		// TODO - implement Game.addPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * Check if the players in the game are ready to start.
         * if all players are ready return true else return false.
	 * @param players
	 */
	public boolean checkReady(List<Player> players) {
		// TODO - implement Game.checkReady
		throw new UnsupportedOperationException();
	}

}