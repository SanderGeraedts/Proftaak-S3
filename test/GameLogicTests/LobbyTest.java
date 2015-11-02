package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Lobby;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasper
 */
public class LobbyTest {
    
    public LobbyTest() {
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
     * Test of hostGame method, of class Lobby.
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testHostGame() {
        System.out.println("hostGame");
        Lobby instance = new Lobby();
        instance.hostGame();
        
        Assert.fail("Not implemented");
    }

    /**
	 * Join a hosted game.
	 * @param gameID
	 */
    @Test
    public void testJoinGame() {
        System.out.println("joinGame");
        int gameID = 0;
        Lobby instance = new Lobby();
        instance.joinGame(gameID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testJoinGameWithInvalidIdentifier() {
        System.out.println("joinGame");
        int gameID = -10;
        Lobby instance = new Lobby();
        instance.joinGame(gameID);
        // TODO review the generated test code and remove the default call to fail.
        fail("Er moest een illegalArgumentException gegooid worden.");
    }
}
