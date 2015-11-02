/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
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
    
    private KeyCode lastDir;
    
    private final int spritesize = 16;
    
    public PlayerController(Player player, Block[][] maze)
    {
        this.player= player;
        this.currentKey = null;
        this.lastDir = KeyCode.DOWN;
        this.maze = maze;
        AnimationTimer timer = new AnimTask();
        timer.start();
    }
    
    public KeyCode getDirection()
    {
        return lastDir;
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
                        playerPos.relocate(playerPos.getLayoutX() -1, playerPos.getLayoutY());
                        spriteMoves--;
                        break;
                    case RIGHT:
                        playerPos.relocate(playerPos.getLayoutX() +1, playerPos.getLayoutY());
                        spriteMoves--;
                        break;
                    case UP:
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() -1);
                        spriteMoves--;
                        break;
                    case DOWN:
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() +1);
                        spriteMoves--;
                        break;
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
                    
            }
            //System.out.println("Current location: " + curX + ":" + curY);
        }
        
    }
    
    //public Move()
}
