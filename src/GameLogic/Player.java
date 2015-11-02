package GameLogic;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

	private int ID;
	private int hitpoints;
        
        private Node location;
        private ImageView imageView;
        
        private PlayerRole playerRole;        

	/**
	 * 
	 * @param id
	 * @param hitpoints
	 * @param cooldown
	 */
	public Player(int id, int hitpoints, int roleID) {
		this.ID = id;
                this.hitpoints = hitpoints;                
                this.playerRole = new PlayerRole(roleID);
                this.imageView = new ImageView();
                imageView.setImage(playerRole.getImage(0));
                this.location = imageView;
                this.location.relocate(0, 0);
	}
        
        public void SpawnPlayer(Node n)
        {
            location.relocate(n.getLayoutX(), n.getLayoutY());
        }
        
        public void setImage(int ID) {
            imageView.setImage(playerRole.getImage(ID));
        }
        
        public Node GetLocation()
        {            
            return location;
        }
        
        public PlayerRole getPlayerRole()
        {
            return playerRole;
        }

}