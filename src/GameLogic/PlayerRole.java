package GameLogic;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class PlayerRole {

    private int ID; //This is the Role ID
    private String name; //This is the Role name.
    private int hitpoints; // This is the amount of hp the character has.
    private Ability[] ability;
    List<Image> defaultImg;
    Ability[] ab = new Ability[3];

    /**
     *
     * @param id
     * @param name
     * @param hitpoints
     */
    public PlayerRole(int id) {
        this.ID = id;
        ability = new Ability[16];
        defaultImg = new ArrayList<Image>();
        createRole(id);
        
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int setHitpoints(int hitpoints) {
        return this.hitpoints = hitpoints;
    }
    
    public Image getImage(int imgID) {
        return defaultImg.get(imgID);
    }

    /**
     * Create all roles. With given ID u select the right Role.
     *
     * @param ID
     */
    public void createRole(int ID) {
        
        List<BufferedImage> spritesheets = new ArrayList<BufferedImage>();
        
        
        switch (ID) {
            case 0:
                name = "Rogue";
                hitpoints = 190;
                defaultImg.add(Sprite.LoadSprite("Resources/Monster.jpg", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/RogueLEFT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/RogueRIGHT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/RogueUP.png", 16, 16));
                for (int i = 0; i < 4; i++) {
                    ability[i] = new Ability(i);
                }
//                ability[0] = new Ability(0);
//                ability[1] = new Ability(1);
//                ability[2] = new Ability(2);
//                ability[3] = new Ability(3);
                break;
            case 1:
                name = "Mage";
                hitpoints = 170;
                defaultImg.add(Sprite.LoadSprite("Resources/Mage-DOWN.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Mage-LEFT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Mage-RIGHT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Mage-UP.png", 16, 16));
                for (int i = 4; i < 8; i++) {
                    ability[i] = new Ability(i);
                }
//                ability[4] = new Ability(4);
//                ability[5] = new Ability(5);
//                ability[6] = new Ability(6);
//                ability[7] = new Ability(7);
                break;
            case 2:
                name = "Warrior";
                hitpoints = 290;
                defaultImg.add(Sprite.LoadSprite("Resources/Warrior-DOWN.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Warrior-LEFT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Warrior-RIGHT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Warrior-UP.png", 16, 16));
                for (int i = 8; i < 12; i++) {
                    ability[i] = new Ability(i);
                }                
//                ability[8] = new Ability(8);
//                ability[9] = new Ability(9);
//                ability[10] = new Ability(10);
//                ability[11] = new Ability(11);
                break;
            case 3:
                name = "Hunter";
                hitpoints = 180;
                defaultImg.add(Sprite.LoadSprite("Resources/Hunter-DOWN.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Hunter-LEFT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Hunter-RIGHT.png", 16, 16));
                defaultImg.add(Sprite.LoadSprite("Resources/Hunter-UP.png", 16, 16));
                for (int i = 12; i < 16; i++) {
                    ability[i] = new Ability(i);
                }                   
//                ability[12] = new Ability(12);
//                ability[13] = new Ability(13);
//                ability[14] = new Ability(14);
//                ability[15] = new Ability(15);
        }
    }

    /*
     * get selected character info.
     */
    @Override
    public String toString() {
        String temp = "Chooses a random character";
        if (ID < 4) {
            temp = "Character info" + "\nName: " + name + "\nHitpoints: " + hitpoints;
            return temp;
        } else {
            return temp;
        }

    }

}
