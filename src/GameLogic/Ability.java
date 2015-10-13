package GameLogic;

public class Ability {

	private String name;
	private int damage;
	private String spriteID;
	private int cooldownTimer;

	/**
	 * 
	 * @param id
	 */
	public Ability(int id) {
            LoadAbility(id);
        }
        
        private void LoadAbility(int id){
            
            switch(id){
                //Rogue role
                case 1:
                    name = "Basic attack";
                    damage = 10;
                    spriteID = "1";
                    cooldownTimer = 1;
                    break;
                case 2:
                    name = "Combo breaker";
                    damage = 30;
                    spriteID = "2";
                    cooldownTimer = 30;
                    break;
                case 3:
                    name = "Poison Trap";
                    damage = 15;
                    spriteID = "3";
                    cooldownTimer = 15;
                    break;
        }
        }
            
        public String GetSkillInfo(){
                String temp = "Name: "+name +"\nDamage: "+damage + "\nCooldown: " + cooldownTimer;
                return temp;
        }

}