package GameLogic;

public class Trap {

	private int ID;
	private int damage;
	private int cooldown;

	/**
	 * 
	 * @param id
	 * @param damage
	 * @param cooldown
	 */
	public Trap(int id, int damage, int cooldown) {
		this.ID = id;
                this.damage = damage;
                this.cooldown = cooldown;
	}

        /**
        *check which player used the trap.
        */
	public int isUsedBy() {
		// TODO - implement Trap.HoortBij
		throw new UnsupportedOperationException();
	}

}