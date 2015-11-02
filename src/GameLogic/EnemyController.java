/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package GameLogic;

import a.maze.ing.AMazeIng;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Sander Geraedts
 *//*
public class EnemyController extends PlayerController{
    
    public EnemyController(AMazeIng guiMaze) {
        
        super(guiMaze);
        
    }
    
    public void AImovement() throws InterruptedException{
        
        int randNr = ThreadLocalRandom.current().nextInt(1, 6);
        
        switch(randNr){
            case 1:
                try{
                    this.moveImage(1,0);
                    this.direction = "RIGHT";
                }
                catch(InterruptedException ex){
                    throw ex;
                }
            case 2:
                try{
                    this.moveImage(0,1);
                    this.direction = "UP";
                }
                catch(InterruptedException ex){
                    throw ex;
                }
            case 3:
                try{
                    this.moveImage(-1,0);
                    this.direction = "LEFT";
                }
                catch(InterruptedException ex){
                    throw ex;
                }
            case 4:
                try{
                    this.moveImage(0,-1);
                    this.direction = "DOWN";
                }
                catch(InterruptedException ex){
                    throw ex;
                }
            case 5:
                int randAbility = ThreadLocalRandom.current().nextInt(1, 4);
                this.useAbility(randAbility);
        }
    }
}
*/