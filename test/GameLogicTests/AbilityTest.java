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
        good = new Ability(1);       
        good = new Ability(-1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConstructor() {
        Ability a = new Ability(-1);
        Ability b = new Ability(1);
        Ability c = new Ability(3);
        Ability d = new Ability(5);
        Ability e = new Ability(2);
        
        assertNull("bad input, should be null", a);
        assertNotNull("Should not be null", b);
        assertNotNull("Should not be null", c);
        assertNull("bad input, should be null", d);
        assertNotNull("Should not be null", e);
    }
    
    @Test
    public void testGetSkillInfo(){
        assertNotNull("Ability good.GetSkillInfo() shouldn't return null", good.GetSkillInfo());
        assertNull("Ability bad.GetSkillInfo() should return null", bad.GetSkillInfo());
    }
}
