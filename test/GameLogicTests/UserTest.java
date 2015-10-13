/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogicTests;

import GameLogic.Stat;
import GameLogic.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roy
 */
public class UserTest {
    
    public UserTest() {
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
     * Test of login method, of class User.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String name = "";
        String password = "";
        User instance = null;
        User expResult = null;
        User result = instance.login(name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAccount method, of class User.
     */
    @Test
    public void testCreateAccount() {
        System.out.println("createAccount");
        String userid = "";
        String name = "";
        String password = "";
        String email = "";
        Stat stats = null;
        User instance = null;
        Boolean expResult = null;
        Boolean result = instance.createAccount(userid, name, password, email, stats);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStats method, of class User.
     */
    @Test
    public void testChangeStats() {
        System.out.println("changeStats");
        int kills = 0;
        int deaths = 0;
        boolean win = false;
        User instance = null;
        instance.changeStats(kills, deaths, win);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
