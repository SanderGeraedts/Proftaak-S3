package GameLogic;

public class Ability {

	private int id;
	private String name;
	private int damage;
	private String spriteID;
	private int cooldownTimer;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param damage
	 * @param spriteID
	 * @param cooldownTimer
	 */
	public Ability(int id, String name, int damage, String spriteID, int cooldownTimer) {
	this.id = id;
        this.name = name;
        this.damage = damage;
        this.spriteID = spriteID;
	this.cooldownTimer = cooldownTimer;
        }

}