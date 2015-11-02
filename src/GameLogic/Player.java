package GameLogic;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

	private int ID;
	private int hitpoints;
        
        private Node location;
        

	/**
	 * 
	 * @param id
	 * @param hitpoints
	 * @param cooldown
	 */
	public Player(int id, int hitpoints) {
		this.ID = id;
                this.hitpoints = hitpoints;
                
                Image player = Sprite.LoadSprite("Resources/Player.jpg", 16, 16);
                this.location = new ImageView(player);
                this.location.relocate(0, 0);
	}
        
        public void SpawnPlayer(Node n)
        {
            location.relocate(n.getLayoutX(), n.getLayoutY());
        }
        
        public Node GetLocation()
        {
            return location;
        }

}