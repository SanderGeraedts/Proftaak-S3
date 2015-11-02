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

    PlayerRole instance;

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

        instance = new PlayerRole(1);

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
        int expResult = 170;
        int result = instance.getHitpoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHitpoints method, of class PlayerRole.
     */
    @Test
    public void testSetHitpoints() {
        System.out.println("setHitpoints");
        int hitpoints = 0;
        int expResult = 0;
        int result = instance.setHitpoints(hitpoints);
        assertEquals(expResult, result);
    }

    /**
     * Test of createRole method, of class PlayerRole.
     */
    @Test
    public void testCreateRole() {
        System.out.println("createRole");
        
        String[] names = {"Rogue", "Mage", "Warrior", "Hunter"};
        int[] hitpoints = {190, 170, 290, 180};
        
        int id = 0;
        String expected = "";
        String result = "";
        
        instance.createRole(id);
        expected = "Character info" + "\nName: " + names[id] + "\nHitpoints: " + hitpoints[id];
        result = instance.toString();
        assertEquals("The result should be the same", expected, result);
        id++;
        
        instance.createRole(id);
        expected = "Character info" + "\nName: " + names[id] + "\nHitpoints: " + hitpoints[id];
        result = instance.toString();
        assertEquals("The result should be the same", expected, result);
        id++;
        
        instance.createRole(id);
        expected = "Character info" + "\nName: " + names[id] + "\nHitpoints: " + hitpoints[id];
        result = instance.toString();
        assertEquals("The result should be the same", expected, result);
        id++;
        
        instance.createRole(id);
        expected = "Character info" + "\nName: " + names[id] + "\nHitpoints: " + hitpoints[id];
        result = instance.toString();
        assertEquals("The result should be the same", expected, result);
        id++;        
    }

    /**
     * Test of getInfo method, of class PlayerRole.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        PlayerRole instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
