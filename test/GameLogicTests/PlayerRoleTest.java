/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogicTests;

import GameLogic.PlayerRole;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hovsep
 */
public class PlayerRoleTest {
    
    public PlayerRoleTest() {
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
     * Test of getHitpoints method, of class PlayerRole.
     */
    @Test
    public void testGetHitpoints() {
        System.out.println("getHitpoints");
        PlayerRole instance = null;
        int expResult = 0;
        int result = instance.getHitpoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHitpoints method, of class PlayerRole.
     */
    @Test
    public void testSetHitpoints() {
        System.out.println("setHitpoints");
        int hitpoints = 0;
        PlayerRole instance = null;
        int expResult = 0;
        int result = instance.setHitpoints(hitpoints);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createRole method, of class PlayerRole.
     */
    @Test
    public void testCreateRole() {
        System.out.println("createRole");
        int ID = 0;
        PlayerRole instance = null;
        instance.createRole(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class PlayerRole.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        PlayerRole instance = null;
        String expResult = "";
        String result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
