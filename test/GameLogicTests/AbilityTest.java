package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Ability;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sander Geraedts
 */
public class AbilityTest {
    Ability good;
    Ability bad;
    
    public AbilityTest() {
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
    //Check
    public void testConstructor() {        

    }
    
    @Test
    public void testGetSkillInfo(){
        assertNotNull("Ability good.GetSkillInfo() shouldn't return null", good.toString());
        assertNull("Ability bad.GetSkillInfo() should return null", bad.toString());
    }
}
