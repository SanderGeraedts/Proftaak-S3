package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Game;
import GameLogic.Player;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasper
 */
public class GameTest {
    
    
    
    public GameTest() {
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
    
    @Test
    public void testConstructor(){
        Game game = new Game(1, 1);
        
        assertNotNull("game shouldn't be null", game);
    }

    /**
     * Test of addPlayer method, of class Game.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Game instance = null;
        instance.addPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkReady method, of class Game.
     */
    @Test
    public void testCheckReady() {
        System.out.println("checkReady");
        List<Player> players = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.checkReady(players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
