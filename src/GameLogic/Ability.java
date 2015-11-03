package GameLogic;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**
 * Todo: add more constraints, class nearly impossible to test.
 * 
* TEST TEST TEST TEST TEST
 */
public class Ability {

    static final int spritesize = 16;

    private String name;
    private int damage;
    private String spriteID;
    private int cooldownTimer;
    public Image img;
    List<Image> images;
    ImageView imageView;
    Node abilityNode;

    private KeyCode moving;
    private Block[][] maze;
    private Group nodes;

    /**
     *
     * @param id
     */
    public Ability(int id, KeyCode moving, Block[][] maze, Group nodes) {
        imageView = new ImageView();
        images = new ArrayList<Image>();
        LoadAbility(id);
        this.moving = moving;
        this.maze = maze;
        this.nodes = nodes;
        AnimationTimer timer = new AnimTask();
        timer.start();
    }

    private class AnimTask extends AnimationTimer {

        double curY;
        double curX;

        Node abilityPos = abilityNode;

        KeyCode animBusy = null;
        int spriteMoves = spritesize;

        @Override
        public void handle(long now) {
            if (animBusy != null) {
                switch (animBusy) {
                    case LEFT:
                        abilityPos.relocate(abilityPos.getLayoutX() - 1, abilityPos.getLayoutY());                        
                        imageView.setImage(images.get(1));
                        abilityNode = imageView;
                        //img = 
                        spriteMoves--;
                        break;
                    case RIGHT:
                        abilityPos.relocate(abilityPos.getLayoutX() + 1, abilityPos.getLayoutY());
                        imageView.setImage(images.get(2));
                        abilityNode = imageView;
                        spriteMoves--;
                        break;
                    case UP:
                        abilityPos.relocate(abilityPos.getLayoutX(), abilityPos.getLayoutY() - 1);
                        imageView.setImage(images.get(3));
                        abilityNode = imageView;
                        spriteMoves--;
                        break;
                    case DOWN:
                        abilityPos.relocate(abilityPos.getLayoutX(), abilityPos.getLayoutY() + 1);
                        imageView.setImage(images.get(0));
                        abilityNode = imageView;
                        spriteMoves--;
                        break;
                }
            }
            if (spriteMoves == 0) {
                spriteMoves = spritesize;
                animBusy = null;
                //moving = null;
                return;
            }

            /*
             if(moving == null)
             {
             if ((curY == Math.floor(curY)) && !Double.isInfinite(curY)) 
             {
                    
             }
             if ((curX == Math.floor(curX)) && !Double.isInfinite(curX)) 
             {
                    
             }
             }*/
            if (moving == null || animBusy != null) {
                return;
            }            

            curY = abilityPos.getLayoutY() / spritesize;
            curX = abilityPos.getLayoutX() / spritesize;
            switch (moving) {
                case LEFT:
                    //playerPos.relocate(abilityPos.getLayoutX() -1, abilityPos.getLayoutY());
                    if (maze[(int) curY][(int) curX - 1] != Block.SOLID) {
                        animBusy = moving;
                    } else {
                        DestructAbility();
                    }
                    break;
                case RIGHT:
                    //playerPos.relocate(abilityPos.getLayoutX() +1, abilityPos.getLayoutY());
                    if (maze[(int) curY][(int) curX + 1] != Block.SOLID) {
                        animBusy = moving;
                    } else {
                        DestructAbility();
                    }
                    break;
                case DOWN:
                    if (maze[(int) curY + 1][(int) curX] != Block.SOLID) {
                        animBusy = moving;
                    } else {
                        DestructAbility();
                    }
                    break;
                case UP:
                    if (maze[(int) curY - 1][(int) curX] != Block.SOLID) {
                        animBusy = moving;
                    } else {
                        DestructAbility();
                    }
                    break;

            }
        }
    }

    public void DestructAbility() {
        nodes.getChildren().remove(abilityNode);        
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
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 1:
                name = "Stealth";
                damage = 30;
                spriteID = "1";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 2:
                name = "Poison Trap";
                damage = 15;
                spriteID = "2";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 3:
                name = "Quick Poison";
                damage = 40;
                spriteID = "3";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;

            //Mage Skills
            case 4:
                name = "Fireball";
                damage = 15;
                spriteID = "4";
                cooldownTimer = 15;
                images.add(Sprite.LoadSprite("Resources/Firebolt-DOWN.png", 16, 16));                
                images.add(Sprite.LoadSprite("Resources/Firebolt-LEFT.png", 16, 16));                
                images.add(Sprite.LoadSprite("Resources/Firebolt-RIGHT.png", 16, 16));
                images.add(Sprite.LoadSprite("Resources/Firebolt-UP.png", 16, 16));
                //img = Sprite.LoadSprite("Resources/Firebolt-DOWN.png", 16, 16);
                //imageView.setImage(img);
                abilityNode = imageView;
                break;
            case 5:
                name = "Frost Block";
                damage = 0;
                spriteID = "5";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/Iceblock-ALL.png", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 6:
                name = "Frost Trap";
                damage = 15;
                spriteID = "6";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/Frosttrap-ALL.png", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 7:
                name = "Ring of Fire";
                damage = 60;
                spriteID = "7";
                cooldownTimer = 50;
                img = Sprite.LoadSprite("Resources/RingOfFire-ALL.png", 16, 16);
                abilityNode = new ImageView(img);
                break;

            //Warrior Skills    
            case 8:
                name = "Charge";
                damage = 15;
                spriteID = "8";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 9:
                name = "Stunning blow";
                damage = 15;
                spriteID = "9";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 10:
                name = "Spike Trap";
                damage = 15;
                spriteID = "10";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 11:
                name = "Heroic Blow";
                damage = 70;
                spriteID = "11";
                cooldownTimer = 60;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;

            //Hunter Skills   
            case 12:
                name = "Precision shot";
                damage = 15;
                spriteID = "12";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 13:
                name = "Hawkshot ";
                damage = 15;
                spriteID = "13";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 14:
                name = "Bear Trap";
                damage = 15;
                spriteID = "14";
                cooldownTimer = 15;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
            case 15:
                name = "Deadly Shot";
                damage = 45;
                spriteID = "15";
                cooldownTimer = 30;
                img = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                abilityNode = new ImageView(img);
                break;
        }
    }

    public Node getAbilityNode() {
        return abilityNode;
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
