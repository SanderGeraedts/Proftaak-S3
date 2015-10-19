package GameLogic;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class PlayerRole {

    private int ID; //This is the Role ID
    private String name; //This is the Role name.
    private int hitpoints; // This is the amount of hp the character has.
    private Ability[] ability;
    Image defaultImg;
    Ability[] ab = new Ability[3];

    /**
     *
     * @param id
     * @param name
     * @param hitpoints
     */
    public PlayerRole(int id) {
        this.ID = id;
        createRole(id);
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int setHitpoints(int hitpoints) {
        return this.hitpoints = hitpoints;
    }

    /**
     * Create all roles. With given ID u select the right Role.
     *
     * @param ID
     */
    public void createRole(int ID) {
        switch (ID) {
            case 0:
                name = "Rogue";
                hitpoints = 190;
                defaultImg = Sprite.LoadSprite("", 16, 16);
                ability[0] = new Ability(0);
                ability[1] = new Ability(1);
                ability[2] = new Ability(2);

                break;
            case 1:
                name = "Mage";
                hitpoints = 170;
                defaultImg = Sprite.LoadSprite("", 16, 16);
                ability[3] = new Ability(3);
                ability[4] = new Ability(4);
                ability[5] = new Ability(5);
                break;
            case 2:
                name = "Warrior";
                hitpoints = 290;
                defaultImg = Sprite.LoadSprite("", 16, 16);
                ability[6] = new Ability(6);
                ability[7] = new Ability(7);
                ability[8] = new Ability(8);
                break;
            case 3:
                name = "Hunter";
                hitpoints = 180;
                defaultImg = Sprite.LoadSprite("", 16, 16);
                ability[9] = new Ability(9);
                ability[10] = new Ability(10);
                ability[11] = new Ability(11);
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
