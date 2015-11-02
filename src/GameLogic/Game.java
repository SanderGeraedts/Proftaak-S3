package GameLogic;


import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;

public class Game {

	private int gameID;
	private int gameState;
        private List<Player> players; 

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
         * 
         * @return players
         */
        public List<Player> getPlayers(){
            return players;
        }                
        
        /**
         * Adds a player to the game
         * 
         * @param player 
         */
	public void addPlayer(Player player) {
            
		players.add(player);
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