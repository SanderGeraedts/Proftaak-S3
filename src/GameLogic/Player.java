package GameLogic;

public class Player {

	private int ID;
	private int hitpoints;
	private boolean isReady;

	/**
	 * 
	 * @param id
	 * @param hitpoints
	 * @param cooldown
	 */
	public Player(int id, int hitpoints, PlayerRole cooldown) {
		this.ID = id;
                this.hitpoints = hitpoints;
	}

}