/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import GameLogic.Block;
import GameLogic.Player;
import GameLogic.Room;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import GameLogic.StellingVanSander;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Robin
 */
public class AIController {
    private Player player;
    private KeyCode moving;
    private Block[][] maze;
    
    private final int spritesize = 16;
    
    private Player trackingPlayer;    
    
    public AIController(Player player, Block[][] maze)
    {
        this.player= player;
        this.moving = null;
        this.maze = maze;
        AnimationTimer timer = new AnimTask();
        Timer aiTimer = new Timer();
        aiTimer.scheduleAtFixedRate(new AITask(), 200, 500);
        timer.start();
        moving = null;
    }
    
    private double calcDistance(Node loc1, Node loc2)
    {
       double length;
        
       double xLength = sqrt(pow((double)loc1.getLayoutX() - (double)loc2.getLayoutX(), 2));
       double yLength = sqrt(pow((double)loc1.getLayoutY() - (double)loc1.getLayoutY(), 2));
       
       length = xLength + yLength;
       
       return length;
    }
            
    private class AITask extends TimerTask
    {   
        @Override
        public void run() 
        {
            if(!player.active)
                this.cancel();
            if(trackingPlayer != null && moving == null)
            {
                Node ploc = player.GetLocation();
                Node tloc = trackingPlayer.GetLocation();
                int absolutePos[] = new int[2];
                absolutePos[0] = (int)(ploc.getLayoutX() /spritesize);
                absolutePos[1] = (int)(ploc.getLayoutY() /spritesize);
                int stuck = 0;
                boolean priorY= false;
                double test = ploc.getLayoutX()-tloc.getLayoutX()*-1;
                double test2 = ploc.getLayoutY()-tloc.getLayoutY()*-1;
                if((ploc.getLayoutX()-tloc.getLayoutX())*-1 /spritesize < (ploc.getLayoutY()-tloc.getLayoutY())*-1/spritesize)
                    priorY=true;
                
                while(moving == null)
                {
                    if(!priorY)
                    {
                        if(ploc.getLayoutX() / spritesize < tloc.getLayoutX() / spritesize)
                        {
                            if(maze[absolutePos[1]][absolutePos[0]+1] != Block.SOLID)
                            {
                                stuck =0;
                                moving = KeyCode.RIGHT;
                                break;
                            }
                            else
                                stuck++;
                        }
                        if(ploc.getLayoutX() / spritesize > tloc.getLayoutX() / spritesize)
                        {
                            if(maze[absolutePos[1]][absolutePos[0] -1] != Block.SOLID)
                            {
                                stuck =0;
                                moving = KeyCode.LEFT;
                                break;
                            }
                            else
                                stuck++;
                        }
                    }

                    if(ploc.getLayoutY() /spritesize < tloc.getLayoutY() /spritesize)
                    {
                        if(maze[absolutePos[1]+1][absolutePos[0]] != Block.SOLID)
                        {
                            stuck =0;
                            moving = KeyCode.DOWN;
                            break;
                        }
                        else
                            stuck++;
                    }
                    if(ploc.getLayoutY() /spritesize > tloc.getLayoutY() /spritesize)
                    {
                        if(maze[absolutePos[1]-1][absolutePos[0]] != Block.SOLID)
                        {
                            stuck = 0;
                            moving = KeyCode.UP;
                            break;
                        }
                        else
                            stuck++;
                    }
                    stuck++;
                    if(stuck >= 3)
                    {
                        priorY=false;
                    }
                }
            }
            
            
            
        }
        
    }
    
    public void StartTracking(Player player)
    {
        trackingPlayer = player;
    }
    
    public void StopTracking()
    {
        trackingPlayer = null;
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
                moving = null;
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
            if(moving == null || animBusy != null)
                return;
            
            
            curY = player.GetLocation().getLayoutY() / spritesize;
            curX = player.GetLocation().getLayoutX() / spritesize;
            switch(moving)
            {
                case LEFT:
                    //playerPos.relocate(playerPos.getLayoutX() -1, playerPos.getLayoutY());
                    if(maze[(int)curY][(int)curX-1] != Block.SOLID)
                        animBusy = moving;
                    else moving = null;
                    break;
                case RIGHT:
                    //playerPos.relocate(playerPos.getLayoutX() +1, playerPos.getLayoutY());
                    if(maze[(int)curY][(int)curX+1] != Block.SOLID)
                        animBusy = moving;
                    else moving = null;
                    break;
                case DOWN:
                    if(maze[(int)curY+1][(int)curX] != Block.SOLID)
                        animBusy = moving;
                    else moving = null;
                    break;
                case UP:
                    if(maze[(int)curY-1][(int)curX] != Block.SOLID)
                        animBusy = moving;
                    else moving = null;
                    break;                    
            }
        }
    }
}
