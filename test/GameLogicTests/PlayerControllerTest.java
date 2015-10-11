package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.PlayerController;
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
public class PlayerControllerTest {
    
    public PlayerControllerTest() {
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
     * Test of isDead method, of class PlayerController.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        PlayerController instance = null;
        instance.isDead();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerMove method, of class PlayerController.
     */
    @Test
    public void testPlayerMove() {
        System.out.println("playerMove");
        PlayerController instance = null;
        instance.playerMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of collisionCheck method, of class PlayerController.
     */
    @Test
    public void testCollisionCheck() {
        System.out.println("collisionCheck");
        PlayerController instance = null;
        instance.collisionCheck();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkDamage method, of class PlayerController.
     */
    @Test
    public void testCheckDamage() {
        System.out.println("checkDamage");
        PlayerController instance = null;
        instance.checkDamage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTrap method, of class PlayerController.
     */
    @Test
    public void testCheckTrap() {
        System.out.println("checkTrap");
        PlayerController instance = null;
        instance.checkTrap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of useAbility method, of class PlayerController.
     */
    @Test
    public void testUseAbility() {
        System.out.println("useAbility");
        int id = 0;
        PlayerController instance = null;
        instance.useAbility(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
