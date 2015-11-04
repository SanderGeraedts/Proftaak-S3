package GameLogic;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Player {

	private int ID;
	private int hitpoints;
        
        private Node location;
        private ImageView imageView;
        
        private PlayerRole playerRole;
        
        public boolean isAi;
        public boolean active = false;
        

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
                isAi= false;
                active =true;
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
        
        public int getID()
        {
            return this.ID;
        }
        
        public PlayerRole getPlayerRole()
        {
            return playerRole;
        }
        
        public void CollisionWith(Player p)
        {
            if(this.isAi && p.isAi){ //Collision between 2 AI players
                //System.out.println("");
            }
            else if(!this.isAi && p.isAi){ //Collision between player(this) and ai(p)
                System.out.println("I: " + this.ID + " Collision with: " + p.getID() + " added 10 damage. HP:" + (hitpoints-10));
                this.hitpoints-=10;
                if(hitpoints < 0)
                {
                    System.out.println("You died! resetting hp..");
                    hitpoints = 100;
                }                
            }
        }
        
        
        public void CollisionWith(Ability a) {
            if(isAi){
                this.hitpoints-=10;
                a.DestructAbility();
                System.out.println("I:" + ID + " Got hit by: " +a.getName() +" HP:" + hitpoints);
                if(hitpoints <= 0)
                    Die();
            }
        }
        
        public void Die() {
            active = false;
            Platform.runLater(new Runnable(){
            @Override
            public void run(){
                location.toBack();
            }
        });
            System.out.println("Someone got killedd!");
        }

}