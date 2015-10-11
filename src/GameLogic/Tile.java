package GameLogic;

public class Tile {

	private int ID;
	private TileType Type;
	private String Location;
	private String Sprite;

	/**
	 * @param id
	 * @param type
	 * @param location
	 * @param sprite
	 */
	public Tile(int id, TileType type, String location, String sprite) {
		this.ID = id;
                this.Type = type;
                this.Location = location;
                this.Sprite = sprite;
	}

}