/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package GameLogic;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;

/**
 *
 * @author Robin
 *//*
public class AnimationController 
{
    private AnimationTimer playerTimer;
    private AnimationTimer aiTimer;
    private AnimationTimer abilityTimer;
    
    private ArrayList<Player> players;
    private ArrayList<Player> aiPlayers;
    private ArrayList<Ability> abilities;
    
    private Maze maze;
    private Group nodes;
    
    public AnimationController(Maze maze, Group group)
    {
        this.maze= maze;
        this.nodes = group;
        
        players = new ArrayList<>();
        aiPlayers = new ArrayList<>();
        abilities = new ArrayList<>();
        
        playerTimer = new playerAnim();
        playerTimer.start();
    }
    
    public void addPlayer(Player p)
    {
        players.add(p);
    }
    
    public void removePlayer(Player p)
    {
        players.remove(p);
        nodes.getChildren().remove(p.GetLocation());
    }
    
    private class playerAnim extends AnimationTimer
    {
        public void handle(long now) 
        {
            for(Player p : players)
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
                            break;
                    }
                }
                if(spriteMoves == 0)
                {
                    spriteMoves = spritesize;
                    animBusy = null;
                    return;
                }*/

                /*
                if(currentKey == null)
                {
                    if ((curY == Math.floor(curY)) && !Double.isInfinite(curY)) 
                    {

                    }
                    if ((curX == Math.floor(curX)) && !Double.isInfinite(curX)) 
                    {

                    }
                }
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
            }
        }
        
    }
    
}*/
