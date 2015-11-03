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
                name = "Shuriken throw";
                damage = 10;
                spriteID = "0";
                cooldownTimer = 1;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 1:
                name = "Stealth";
                damage = 30;
                spriteID = "1";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 2:
                name = "Poison Trap";
                damage = 15;
                spriteID = "2";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 3:
                name = "Quick Poison";
                damage = 40;
                spriteID = "3";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16,16);
                break;

            //Mage Skills
            case 4:
                name = "Fireball";
                damage = 15;
                spriteID = "4";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 5:
                name = "Frost Block";
                damage = 0;
                spriteID = "5";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 6:
                name = "Frost Trap";
                damage = 15;
                spriteID = "6";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 7:
                name = "Ring of Fire";
                damage = 60;
                spriteID = "7";
                cooldownTimer = 50;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                break;

            //Warrior Skills    
            case 8:
                name = "Charge";
                damage = 15;
                spriteID = "8";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 9:
                name = "Stunning blow";
                damage = 15;
                spriteID = "9";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 10:
                name = "Spike Trap";
                damage = 15;
                spriteID = "10";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 11:
                name = "Heroic Blow";
                damage = 70;
                spriteID = "11";
                cooldownTimer = 60;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                break;

            //Hunter Skills   
            case 12:
                name = "Precision shot";
                damage = 15;
                spriteID = "12";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 13:
                name = "Hawkshot ";
                damage = 15;
                spriteID = "13";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 14:
                name = "Bear Trap";
                damage = 15;
                spriteID = "14";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg",16,16);
                break;
            case 15:
                name = "Deadly Shot";
                damage = 45;
                spriteID = "15";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
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
