package GameLogic;


import javafx.scene.image.Image;


/**
* Todo: add more constraints, class nearly impossible to test.
* 
* TEST TEST TEST TEST TEST 
*/
public class Ability {

    private String name;
    private int damage;
    private String spriteID;
    private int cooldownTimer;
    public Image img;

    /**
     *
     * @param id
     */
    public Ability(int id) {
        LoadAbility(id);
    }

    /*
     *Create all Abilities. With given ID u select the right Role.
     * @param id
     */
    private void LoadAbility(int id) {

        switch (id) {
            //Rogue Skills
            case 0:
                name = "Dagger throw";
                damage = 10;
                spriteID = "1";
                cooldownTimer = 1;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 1:
                name = "Stealth";
                damage = 30;
                spriteID = "2";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 2:
                name = "Poison Trap";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;

            //Mage Skills
            case 3:
                name = "Fireball";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 4:
                name = "Iceball";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 5:
                name = "Poep Trap";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;

            //Warrior Skills    
            case 6:
                name = "Charge";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 7:
                name = "Sunning blow";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 8:
                name = "Spike Trap";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;

            //Hunter Skills   
            case 9:
                name = "Precision shot";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 10:
                name = "Hawkshot ";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
            case 11:
                name = "Bear Trap";
                damage = 15;
                spriteID = "3";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("",16,16);
                break;
        }
    }

    
    /*
    *  Get al Ability Information
    */
    @Override
    public String toString() {
        String temp = "Name: " + name + "\nDamage: " + damage + "\nCooldown: " + cooldownTimer;
        return temp;
    }

}
