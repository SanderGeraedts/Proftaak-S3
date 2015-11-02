package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Game;
import GameLogic.Player;
import GameLogic.PlayerRole;
import java.util.ArrayList;
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
    
    Game game;
    
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
        game = new Game(1, 1);
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
     */ /*
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player1 = new Player(1, 1, new PlayerRole(1));
        
        game.addPlayer(player1);
        
        List<Player> expected = new ArrayList<Player>();
        expected.add(player1);
        
        List<Player> result = game.getPlayers();
        
        assertEquals("game.players should be equal to expected", expected, result);
    }*/
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerNull(){
        System.out.println("addPlayer null");
        Player player1 = null;
        
        game.addPlayer(player1);
        
        fail("Exception should have been thrown");
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
    }
    /*
    @Test
    public void testGetPlayers(){
        System.out.println("getPlayer");
        Player player1 = new Player(1, 1, new PlayerRole(1));
        Player player2 = new Player(1, 1, new PlayerRole(1));
        Player player3 = new Player(1, 1, new PlayerRole(1));
        Player player4 = new Player(1, 1, new PlayerRole(1));
        
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        
        List<Player> expected = new ArrayList<Player>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        expected.add(player4);
        
        List<Player> result = game.getPlayers();
        
        assertNotNull("Result shouldn't be null", result);
        assertEquals("Result should be the same as the expected result", result, expected);
    }*/
    
}
