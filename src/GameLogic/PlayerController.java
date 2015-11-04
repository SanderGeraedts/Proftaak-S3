/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Robin
 */
public class PlayerController 
{
    private Player player;
    private KeyCode currentKey;
    private Block[][] maze;
    private Image currentImage;
    
    private KeyCode lastDir;
    
    private final int spritesize = 16;
    
    private Ability ab1;
    private Ability ab2;
    private Ability ab3;
    private Ability ab4;
    
    private Group nodes;
    
    
    public PlayerController(Player player, Block[][] maze, Group nodes)
    {
        this.player= player;
        this.currentKey = null;
        this.lastDir = KeyCode.DOWN;
        this.maze = maze;
        this.nodes= nodes;
        AnimationTimer timer = new AnimTask();
        timer.start();
    }
    
    public KeyCode getDirection()
    {
        return lastDir;
    }
    
    public Ability getAbility(int ID, CollisionController cc) {
        switch (ID) {
            case 1:
                ab1= new Ability((player.getPlayerRole().getID()* 4) + 0, getDirection(), maze, nodes);
                ab1.abilityNode.relocate(player.GetLocation().getLayoutX(), player.GetLocation().getLayoutY());
                cc.addAbility(ab1);
                return ab1;
            case 2:
                return ab2;
            case 3:
                return ab3;
            case 4:
                return ab4;
            default:
                return null;
        }
    }
    
    public void setCurrentKey(KeyCode kc)
    {
        currentKey = kc;
        if(kc != null)
            lastDir = kc;
        //System.out.println(lastDir);
    }
    
    public KeyCode getCurrentKey()
    {
        return currentKey;
    }
    
    private class AnimTask extends AnimationTimer
    {
        double curY;
        double curX;
        
        Node playerPos = player.GetLocation();        
        
        KeyCode animBusy = null;
        int spriteMoves = spritesize;
        
        @Override
        public void handle(long now) 
        {
            if(animBusy != null)
            {
                switch(animBusy)
                {
                    case LEFT:
                        player.setImage(1);
                        playerPos.relocate(playerPos.getLayoutX() -1, playerPos.getLayoutY());
                        //currentImage = player.PlayerRole.getImage(1);
                        spriteMoves--;
                        break;
                    case RIGHT:
                        player.setImage(2);
                        playerPos.relocate(playerPos.getLayoutX() +1, playerPos.getLayoutY());
                        //currentImage = playerRole.getImage(2);
                        spriteMoves--;
                        break;
                    case UP:
                        player.setImage(3);
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() -1);
                        //currentImage = playerRole.getImage(3);
                        spriteMoves--;
                        break;
                    case DOWN:
                        player.setImage(0);
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() +1);
                        //currentImage = playerRole.getImage(0);
                        spriteMoves--;
                        break;
                        /*
                    case DIGIT1:
                        //ab1 = new Ability((player.getPlayerRole().getID()* 4) + 0);
                        
                        break;
                    case DIGIT2:
                        ab2 = new Ability((player.getPlayerRole().getID()* 4) + 1);
                        break;
                    case DIGIT3:
                        ab3 = new Ability((player.getPlayerRole().getID()* 4) + 2);
                        break;
                    case DIGIT4:
                        ab4 = new Ability((player.getPlayerRole().getID()* 4) + 3);
                        break;*/
                }
            }
            if(spriteMoves == 0)
            {
                spriteMoves = spritesize;
                animBusy = null;
                return;
            }
            
            /*
            if(currentKey == null)
            {
                if ((curY == Math.floor(curY)) && !Double.isInfinite(curY)) 
                {
                    
                }
                if ((curX == Math.floor(curX)) && !Double.isInfinite(curX)) 
                {
                    
                }
            }*/
            if(currentKey == null || animBusy != null)
                return;
            
            
            curY = player.GetLocation().getLayoutY() / spritesize;
            curX = player.GetLocation().getLayoutX() / spritesize;
            switch(currentKey)
            {
                case LEFT:
                    //playerPos.relocate(playerPos.getLayoutX() -1, playerPos.getLayoutY());
                    if(maze[(int)curY][(int)curX-1] != Block.SOLID)
                        animBusy = currentKey;
                    break;
                case RIGHT:
                    //playerPos.relocate(playerPos.getLayoutX() +1, playerPos.getLayoutY());
                    if(maze[(int)curY][(int)curX+1] != Block.SOLID)
                    animBusy = currentKey;
                    break;
                case DOWN:
                    if(maze[(int)curY+1][(int)curX] != Block.SOLID)
                    animBusy = currentKey;
                    break;
                case UP:
                    if(maze[(int)curY-1][(int)curX] != Block.SOLID)
                    animBusy = currentKey;
                    break;
                    
                case DIGIT1:
                    animBusy = currentKey;
                    break;
                case DIGIT2:
                    animBusy = currentKey;
                    break;   
                case DIGIT3:
                    animBusy = currentKey;
                    break;   
                case DIGIT4:
                    animBusy = currentKey;
                    break;    
            }            
            //System.out.println("Current location: " + curX + ":" + curY);
        }
        
    }
    
    //public Move()
}
