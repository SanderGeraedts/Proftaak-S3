package GameLogicTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sander Geraedts
 */
public class RoomTest {
    
    Room base;
    
    public RoomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        base = new Room(1, 1, 3, 2, false);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * 
     * @param x: The x-coordinate of the room. Must be higher than 0.
     * @param y: The y-coordinate of the room. Must be higher than 0.
     * @param w: The width of the room. Must be higher than 1.
     * @param h: The height of the room. Must be higher than 1.
     * @param edge: if the room is a part of the edge of the maze, return true, else false.
     */
    @Test
    public void testConstructor(){
        Room room1 = new Room(1, 1, 2, 2, false);
        Room room2 = new Room(1, 1, 2, 2, true);
        
        assertNotNull("Shouldn't be null", room1);
        assertNotNull("Shouldn't be null", room2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeXConstructor(){
        Room room1 = new Room(-1, 2, 2, 2, false);
        Assert.fail("X should be higher than 0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeYConstructor(){
        Room room1 = new Room(2, -2, 2, 2, false);
        Assert.fail("X should be higher than 0");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWConstructor(){
        Room room1 = new Room(2, 2, -2, 2, false);
        Assert.fail("X should be higher than 0");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHConstructor(){
        Room room1 = new Room(2, 2, 2, -2, false);
        Assert.fail("X should be higher than 0");
    }
    
     /**
     * Checks if [rooomin] overlaps with this room combined with the [roomOffset].
     * 
     * @param roomin: The room which needs to be checked if it overlaps with this room
     * @return true if the room overlaps, else false.
     */
    @Test
    public void testOverlapsWith() {
        Room noOverlap = new Room(8, 8, 2, 2, false);
        Room overlap = new Room(2, 2, 4, 4, false);
        
        assertFalse("Rooms didn't overlap, so false should be returned", base.OverLapsWith(noOverlap));
        assertTrue("Rooms did overlap, so true should be returned", base.OverLapsWith(overlap));
    }
    
    /**
     * Calculates the approximate lenght between this room and [room]. Returns the lenght as a double
     * 
     * @param room
     * @return the length as a double
     */
    @Test
    public void testCalcLength(){
        Room room1 = new Room(0, 0, 2, 2, false);
        Room room2 = new Room(4, 4, 2, 2, false);
        
        assertEquals("Length should be equal to 8.0", 8.0, room1.CalcLength(room2));
        
        room1 = new Room(39, 59, 2, 2, false);
        room2 = new Room(21, 26, 2, 2, false);
        
        assertEquals("Lenght should be equal to 44.0", 44.0, room1.CalcLength(room2));
    }
}
