package GameLogic;

public class PlayerRole {

	private int ID; //This is the Role ID
	private String name; //This is the Role name.
	private int hitpoints; // This is the amount of hp the character has.
        private Ability[] ability;
	/**
	 * 
	 * @param id
	 * @param name
	 * @param hitpoints
	 */
	public PlayerRole(int id) {
               
               this.ID = id;
                
               ability = new Ability[3];
                
               ability[0] = new Ability((ID * 3) + 1);
               ability[1] = new Ability((ID * 3) + 2);
               ability[2] = new Ability((ID * 3) + 3);
                
                createRole(id);
	}
        
        public int getHitpoints(){
            return hitpoints;
        }
        public int setHitpoints(int hitpoints){
            return this.hitpoints = hitpoints;
        }
        
        
        
        /**
        *Create a new Role. With given abilities
     * @param ID
        */
	public void createRole(int ID) {
            switch(ID){
            case 0:
                    name = "Rogue";
                    hitpoints = 190;
                break;
            case 1:
                    name = "Mage";
                    hitpoints = 170;
                break;
            case 2:
                    name = "Warrior";
                    hitpoints = 290;
                break;
            case 3:
                    name = "Gunner";
                    hitpoints = 180;
            }
		
	}
        
        public String getInfo(){
          String temp = "Chooses a random character";
            if( ID  < 4){
               temp = "Character info"+"\nName: "+ name + "\nHitpoints: "+ hitpoints;
               return temp; 
           }
           else{
                return temp;
           }
                
        }


}