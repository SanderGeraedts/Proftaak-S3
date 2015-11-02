/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogicTests;

import GameLogic.Maze;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robin
 */
public class MazeTest {
    
    public MazeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
         * 
         * @param gridsize: The size of the grid in blocks. If gridsize = 16, the maze will be 16x16 blocks.
         * @param roomsize: The max width or heigth of a room.
         * @param roomtries: The number of times the maze tries to generate a room 
         */
    @Test(expected = IllegalArgumentException.class)
    public void testMazeIllegalGridsize(){
        
        System.out.println("printMaze");
        Maze maze = new Maze(-2, 24, 48);
        
        
        
    }

    /**
     * Test of printMaze method, of class Maze.
     */
    @Test
    public void testPrintMaze() {
        System.out.println("printMaze");
        Maze instance = null;
        instance.printMaze();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of spawnBuff method, of class Maze.
     */
    @Test
    public void testSpawnBuff() {
        System.out.println("spawnBuff");
        Maze instance = null;
        instance.spawnBuff();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
